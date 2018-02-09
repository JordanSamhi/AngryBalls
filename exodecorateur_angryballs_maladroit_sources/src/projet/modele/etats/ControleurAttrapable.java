package projet.modele.etats;

import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapable extends ControleurEtatBillePilotee {

	public ControleurAttrapable(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		super(bille, next, previous);
	}
	
}
