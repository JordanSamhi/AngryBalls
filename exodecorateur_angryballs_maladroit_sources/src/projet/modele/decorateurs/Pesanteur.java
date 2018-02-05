package src.projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import src.projet.modele.Bille;
import src.projet.modele.BilleDecorateur;

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
		this.getAccélération().ajoute(this.pesanteur);
	}

}
