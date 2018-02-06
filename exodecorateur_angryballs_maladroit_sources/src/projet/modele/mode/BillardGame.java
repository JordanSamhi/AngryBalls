package projet.modele.mode;

import java.awt.Color;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleNue;
import projet.modele.decorateurs.RebondBord;

public class BillardGame extends Mode{

	public BillardGame() {
		super();
	}

	@Override
	protected void preparerBilles() {
		Bille b[] = new Bille[11];

		double espaceHauteur = (this.yMax - 4 * this.diametre)/2;
		double decalageDecollerBilles = 2;
		
		b[0] = new BilleNue(new Vecteur(this.diametre * 2, espaceHauteur + this.rayon), this.rayon, Color.blue);
		b[1] = new BilleNue(b[0].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.red);
		b[2] = new BilleNue(b[1].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.yellow);
		b[3] = new BilleNue(b[2].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.orange);
		
		b[4] = new BilleNue(b[0].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, Color.green);
		b[5] = new BilleNue(b[4].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.black);
		b[6] = new BilleNue(b[5].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.magenta);
		
		b[7] = new BilleNue(b[4].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, Color.cyan);
		b[8] = new BilleNue(b[7].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.pink);
		
		b[9] = new BilleNue(b[7].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, Color.gray);
		
		b[10] = new BilleNue(new Vecteur(xMax - 3 * this.diametre, b[9].getPosition().y), this.rayon, Color.white);
		
		for(int i = 0 ; i < 11 ; i++) {
			b[i] = new RebondBord(b[i]);
			this.billes.add(b[i]);
		}
	}

}
