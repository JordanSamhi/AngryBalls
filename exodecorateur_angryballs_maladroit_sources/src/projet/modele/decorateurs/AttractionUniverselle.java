package projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;
import projet.modele.OutilsBille;

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
