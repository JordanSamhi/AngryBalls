package src.projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import src.projet.modele.Bille;
import src.projet.modele.BilleDecorateur;

public class PasseATravers extends BilleDecorateur {

	public PasseATravers(Bille next) {
		super(next);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		
	}

}
