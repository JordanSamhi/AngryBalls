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
	public void gestionAccélération(Vector<Bille> billes){
		this.getNext().gestionAccélération(billes);
		this.getAccélération().set(Vecteur.VECTEURNUL);
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));
	}
}
