package src.projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import src.projet.modele.Bille;
import src.projet.modele.BilleDecorateur;
import src.projet.modele.OutilsBille;

public class AttractionUniverselle extends BilleDecorateur {

	public AttractionUniverselle(Bille next) {
		super(next);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes){
		this.getNext().gestionAcc�l�ration(billes);
		this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
		this.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));
	}
}
