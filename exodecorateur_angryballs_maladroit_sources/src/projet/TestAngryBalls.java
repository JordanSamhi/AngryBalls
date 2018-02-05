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
		
		b1 = new BilleNue(Vecteur.créationAléatoire(0, 0, xMax, yMax), rayon, Color.red);
		b1 = new MouvementRectiligneUniforme(b1, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax));
		b1 = new RebondBord(b1);
		
		b2 = new BilleNue(Vecteur.créationAléatoire(0, 0, xMax, yMax), rayon, Color.blue);
		b2 = new MouvementRectiligneUniforme(b2, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax));
		b2 = new PasseATravers(b2);
		
		b3 = new BilleNue(Vecteur.créationAléatoire(0, 0, xMax, yMax), rayon, Color.green);
		b3 = new AttractionUniverselle(b3);
		b3 = new Frottement(b3);
		b3 = new RebondBord(b3);
		
		b4 = new BilleNue(Vecteur.créationAléatoire(0, 0, xMax, yMax), rayon, Color.yellow);
		b4 = new Pesanteur(b4, pesanteur);
		b4 = new Frottement(b4);
		b4 = new RebondBord(b4);
		
		b5 = new BilleNue(Vecteur.créationAléatoire(0, 0, xMax, yMax), rayon, Color.black);
		b5 = new MouvementRectiligneUniforme(b5, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax));
		b5 = new RebondBordBloque(b5);
		b5 = new AttractionUniverselle(b5);
		
		billes.add(b1);
		billes.add(b2);
		billes.add(b3);
		billes.add(b4);
		billes.add(b5);
		
		//---------------------- ici finit la partie à changer -------------------------------------------------------------


		System.out.println("billes = " + billes);


		//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

		//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

		EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
		EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);
		EcouteurBoutonReset écouteurBoutonReset = new EcouteurBoutonReset(animationBilles); 

		//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------


		cadre.lancerBilles.addActionListener(écouteurBoutonLancer);             // maladroit : à changer
		cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);           // maladroit : à changer
		cadre.resetBilles.addActionListener(écouteurBoutonReset);
	}

}
