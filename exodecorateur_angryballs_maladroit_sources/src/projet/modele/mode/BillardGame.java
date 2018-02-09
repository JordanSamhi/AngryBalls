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
		
		b[0] = new BilleNue(new Vecteur(this.diametre * 2, espaceHauteur + this.rayon), this.rayon, new Color(0, 0, 204));
		b[1] = new BilleNue(b[0].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, new Color(204, 0, 0));
		b[2] = new BilleNue(b[1].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, new Color(204, 204, 0));
		b[3] = new BilleNue(b[2].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, new Color(255, 128, 0));
		
		b[4] = new BilleNue(b[0].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, new Color(0, 153, 0));
		b[5] = new BilleNue(b[4].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, Color.black);
		b[6] = new BilleNue(b[5].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, new Color(204, 0 ,204));
		
		b[7] = new BilleNue(b[4].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, new Color(102, 0 , 204));
		b[8] = new BilleNue(b[7].getPosition().somme(new Vecteur(0, this.diametre + decalageDecollerBilles)), this.rayon, new Color(0, 204, 102));
		
		b[9] = new BilleNue(b[7].getPosition().somme(new Vecteur(this.diametre, this.rayon)), this.rayon, new Color(0, 128, 255));
		
		b[10] = new BilleNue(new Vecteur(xMax - 3 * this.diametre, b[9].getPosition().y), this.rayon, Color.white);
		
		for(int i = 0 ; i < 11 ; i++) {
			b[i] = new RebondBord(b[i]);
			this.billes.add(b[i]);
		}
	}

	@Override
	public Color getColorTable() {
		return new Color(0, 102, 0);
	}

}
