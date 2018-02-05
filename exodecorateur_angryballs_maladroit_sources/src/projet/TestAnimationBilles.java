package projet;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleNue;
import projet.modele.decorateurs.MouvementRectiligneUniforme;
import projet.modele.decorateurs.PasseATravers;
import projet.vues.VueBillard;

public class TestAnimationBilles
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Vector<Bille> billes = new Vector<Bille>();

		Vecteur centreBille1 = new Vecteur(110,70);
		double rayonBille1 = 12;
		Vecteur vitesseBille1 = new Vecteur (10,-30);
		Bille bille1 = new BilleNue(centreBille1, rayonBille1, Color.blue);
		bille1 = new MouvementRectiligneUniforme(bille1, vitesseBille1);
		bille1 = new PasseATravers(bille1);
		billes.add(bille1);

		Vecteur centreBille2 = new Vecteur(20,50);
		double rayonBille2 = 15;
		Vecteur vitesseBille2 = new Vecteur (5,-5);
		Bille bille2 = new BilleNue(centreBille2, rayonBille2, Color.blue);
		bille2 = new MouvementRectiligneUniforme(bille2, vitesseBille2);
		bille2 = new PasseATravers(bille2);
		billes.add(bille2);


		double vmax2 = AnimationBilles.maxVitessesCarrées(billes);
		double rayonmin2 = AnimationBilles.minRayons(billes);

		System.out.println("vmax2 = " + vmax2 + "rayonMin2 = " + rayonmin2);
		
		VueBillard vueBillardFactice = new VueBillardFactice();

		AnimationBilles animation = new AnimationBilles(billes, vueBillardFactice);
		animation.lancerAnimation();
	}

}
