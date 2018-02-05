package src.projet;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import src.projet.ecouteur.EcouteurBoutonArreter;
import src.projet.ecouteur.EcouteurBoutonLancer;
import src.projet.ecouteur.EcouteurBoutonReset;
import src.projet.modele.Bille;
import src.projet.modele.BilleNue;
import src.projet.modele.decorateurs.AttractionUniverselle;
import src.projet.modele.decorateurs.Frottement;
import src.projet.modele.decorateurs.MouvementRectiligneUniforme;
import src.projet.modele.decorateurs.PasseATravers;
import src.projet.modele.decorateurs.Pesanteur;
import src.projet.modele.decorateurs.RebondBord;
import src.projet.modele.decorateurs.RebondBordBloque;
import src.projet.vues.CadreAngryBalls;

public class TestAngryBalls{

	public static void main(String[] args)
	{
		Vector<Bille> billes = new Vector<Bille>();
		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls", "Projet Design Pattern SAMHI - ALMEFTAH - AITAAZIZE", billes);
		cadre.montrer();

		double xMax, yMax;
		double vMax = 0.1;
		xMax = cadre.largeurBillard();
		yMax = cadre.hauteurBillard();
		double rayon = 0.05 * Math.min(xMax, yMax);

		Bille b1, b2, b3, b4, b5;
		Vecteur pesanteur = new Vecteur(0,0.001);
		
		b1 = new BilleNue(Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax), rayon, Color.red);
		b1 = new MouvementRectiligneUniforme(b1, Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax));
		b1 = new RebondBord(b1);
		
		b2 = new BilleNue(Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax), rayon, Color.blue);
		b2 = new MouvementRectiligneUniforme(b2, Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax));
		b2 = new PasseATravers(b2);
		
		b3 = new BilleNue(Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax), rayon, Color.green);
		b3 = new AttractionUniverselle(b3);
		b3 = new Frottement(b3);
		b3 = new RebondBord(b3);
		
		b4 = new BilleNue(Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax), rayon, Color.yellow);
		b4 = new Pesanteur(b4, pesanteur);
		b4 = new Frottement(b4);
		b4 = new RebondBord(b4);
		
		b5 = new BilleNue(Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax), rayon, Color.black);
		b5 = new MouvementRectiligneUniforme(b5, Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax));
		b5 = new RebondBordBloque(b5);
		b5 = new AttractionUniverselle(b5);
		
		billes.add(b1);
		billes.add(b2);
		billes.add(b3);
		billes.add(b4);
		billes.add(b5);
		
		//---------------------- ici finit la partie � changer -------------------------------------------------------------


		System.out.println("billes = " + billes);


		//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

		//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------

		EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
		EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles);
		EcouteurBoutonReset �couteurBoutonReset = new EcouteurBoutonReset(animationBilles); 

		//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------


		cadre.lancerBilles.addActionListener(�couteurBoutonLancer);             // maladroit : � changer
		cadre.arr�terBilles.addActionListener(�couteurBoutonArr�ter);           // maladroit : � changer
		cadre.resetBilles.addActionListener(�couteurBoutonReset);
	}

}
