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
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.getNext().gestionAcc�l�ration(billes);
		this.getAcc�l�ration().set(new Vecteur());
		// Pourquoi VECTEUR NUL FAIT TOUT BUGUER ?????????????
		//this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
		this.getAcc�l�ration().ajoute(this.pesanteur);
	}

}
