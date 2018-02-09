package projet.modele.etats;

import projet.modele.decorateurs.BillePilotee;

public abstract class ControleurEtatBillePilotee {
	
	ControleurEtatBillePilotee next, previous;
	BillePilotee bille;

	public ControleurEtatBillePilotee(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		this.bille = bille;
		this.previous = previous;
		this.next = next;
	}

	public ControleurEtatBillePilotee getNext() {
		return next;
	}

	public void setNext(ControleurEtatBillePilotee next) {
		this.next = next;
	}

	public ControleurEtatBillePilotee getPrevious() {
		return previous;
	}

	public void setPrevious(ControleurEtatBillePilotee previous) {
		this.previous = previous;
	}
	
}
