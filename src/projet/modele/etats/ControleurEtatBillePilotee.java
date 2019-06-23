package projet.modele.etats;

import java.awt.event.MouseEvent;

import projet.modele.cor.MouseEventExpertCOR;
import projet.modele.decorateurs.BillePilotee;

public abstract class ControleurEtatBillePilotee {
	
	private ControleurEtatBillePilotee next, previous;
	private BillePilotee bille;
	protected MouseEventExpertCOR expert;
	
	public ControleurEtatBillePilotee(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		this.bille = bille;
		this.setPrevious(previous);
		this.setNext(next);
	}
	
	public void handleMouseEvent(MouseEvent e){
		this.expert.traiteEvenement(e, this);
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
	
	public BillePilotee getBille() {
		return bille;
	}
}
