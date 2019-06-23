package projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class PasseATravers extends BilleDecorateur {

	public PasseATravers(Bille next) {
		super(next);
	}

	@Override
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		return false;
	}

}
