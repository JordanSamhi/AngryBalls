package projet.modele.decorateurs;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;

public class Frottement extends BilleDecorateur {

	public Frottement(Bille next) {
		super(next);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.getNext().gestionAcc�l�ration(billes);
		this.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));	
	}
}
