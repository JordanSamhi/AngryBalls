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
	public void gestionAccélération(Vector<Bille> billes){
		this.getNext().gestionAccélération(billes);
		this.getAccélération().set(Vecteur.VECTEURNUL);
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));
	}
}
