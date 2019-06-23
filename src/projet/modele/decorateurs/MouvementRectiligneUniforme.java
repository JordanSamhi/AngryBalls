package projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class MouvementRectiligneUniforme extends BilleDecorateur {
	
	public Vecteur mouvement;

	public MouvementRectiligneUniforme(Bille next, Vecteur mouvement) {
		super(next);
		this.mouvement = mouvement;
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.getNext().gestionAccélération(billes);
		this.getNext().setVitesse(this.mouvement);
	}
	
	public void setVitesse(Vecteur vitesse) {
		this.mouvement = vitesse;
	}
}
