package projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class Pesanteur extends BilleDecorateur {
	
	Vecteur pesanteur;
	
	public Pesanteur(Bille next, Vecteur pesanteur) {
		super(next);
		this.pesanteur = pesanteur;
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.getNext().gestionAccélération(billes);
		this.getAccélération().set(new Vecteur());
		// Pourquoi VECTEUR NUL FAIT TOUT BUGUER ?????????????
		//this.getAccélération().set(Vecteur.VECTEURNUL);
		this.getAccélération().ajoute(this.pesanteur);
	}

}
