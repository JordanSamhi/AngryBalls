package projet.modele.etats;

import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapee extends ControleurEtatBillePilotee {

	public ControleurAttrapee(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		super(bille, next, previous);
	}


}
