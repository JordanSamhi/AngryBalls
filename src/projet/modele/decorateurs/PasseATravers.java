package projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class PasseATravers extends BilleDecorateur {

	public PasseATravers(Bille next) {
		super(next);
	}

	@Override
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		return false;
	}

}
