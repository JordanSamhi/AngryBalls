package projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class RebondBordBloque extends BilleDecorateur {
	
	public RebondBordBloque(Bille next) {
		super(next);
	}

	@Override
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
		return false;
	}

}
