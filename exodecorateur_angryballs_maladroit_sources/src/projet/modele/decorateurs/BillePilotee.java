package projet.modele.decorateurs;

import java.awt.event.MouseEvent;

import projet.modele.Bille;
import projet.modele.BilleDecorateur;
import projet.modele.etats.ControleurAttrapable;
import projet.modele.etats.ControleurAttrapee;
import projet.modele.etats.ControleurEtatBillePilotee;

public class BillePilotee extends BilleDecorateur{
	
	ControleurEtatBillePilotee controleurCourant;
	ControleurAttrapable controleurAttrapable;
	ControleurAttrapee controleurAttrapee;
	
	public BillePilotee(Bille next) {
		super(next);
		this.genererGrapheControleurs();
	}

	private void genererGrapheControleurs() {
		this.controleurAttrapable = new ControleurAttrapable(this, null, null);
		this.controleurAttrapee = new ControleurAttrapee(this, this.controleurAttrapable, this.controleurAttrapable);
		this.controleurAttrapable.setPrevious(this.controleurAttrapee);
		this.controleurAttrapable.setNext(this.controleurAttrapee);
		this.controleurCourant = this.controleurAttrapable;
	}
	
	public void handleMousePressed(MouseEvent e) {
		this.getControleurCourant().handleMousePressed(e);
	}
	
	public void handleMouseDragged(MouseEvent e) {
		this.getControleurCourant().handleMouseDragged(e);
	}
	
	public void handleMouseReleased(MouseEvent e) {
		this.getControleurCourant().handleMouseReleased(e);
	}

	public ControleurEtatBillePilotee getControleurCourant() {
		return controleurCourant;
	}

	public ControleurAttrapable getControleurAttrapable() {
		return controleurAttrapable;
	}

	public ControleurAttrapee getControleurAttrapee() {
		return controleurAttrapee;
	}

	public void setControleurCourant(ControleurEtatBillePilotee controleurCourant) {
		this.controleurCourant = controleurCourant;
	}
}
