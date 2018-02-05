package src.projet.modele.decorateurs;

import mesmaths.cinematique.Collisions;
import src.projet.modele.Bille;
import src.projet.modele.BilleDecorateur;

public class RebondBord extends BilleDecorateur {
	
	public RebondBord(Bille next) {
		super(next);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.getNext().collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), 
				this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
