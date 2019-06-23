package projet.modele.cor;

import java.awt.event.MouseEvent;

import projet.modele.decorateurs.BillePilotee;
import projet.modele.etats.ControleurEtatBillePilotee;

public class MouseEventReleased extends MouseEventExpertCOR {

	public MouseEventReleased(MouseEventExpertCOR m, BillePilotee bille) {
		super(m, bille);
	}

	/**
	 * Si on lache souris, etat suivant.
	 */
	@Override
	public boolean reconnaitEvent(MouseEvent e, ControleurEtatBillePilotee controleur) {
		if(e.getID() == MouseEvent.MOUSE_RELEASED){
			this.bille.setControleurCourant(controleur.getNext());
			return true;
		}
		return false;
	}

}
