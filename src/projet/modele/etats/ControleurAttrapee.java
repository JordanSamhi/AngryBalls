package projet.modele.etats;

import projet.modele.cor.MouseEventDragged;
import projet.modele.cor.MouseEventReleased;
import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapee extends ControleurEtatBillePilotee {

	/**
	 * 
	 * @param bille
	 * @param next
	 * @param previous
	 * 
	 * Ce controleur contient deux experts qui gèrent les events
	 * mouse dragged et mouse released
	 */
	public ControleurAttrapee(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		super(bille, next, previous);
		this.expert = new MouseEventDragged(null, bille);
		this.expert = new MouseEventReleased(this.expert, bille);
	}
}
