package projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class RebondBord extends BilleDecorateur {
	
	public RebondBord(Bille next) {
		super(next);
	}

	@Override
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		return Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), 
				this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
