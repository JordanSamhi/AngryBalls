package projet.modele.cor;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;
import projet.modele.etats.ControleurEtatBillePilotee;

public abstract class MouseEventExpertCOR implements MouseEventExpert {
	
	private MouseEventExpertCOR next;
	protected BillePilotee bille;

	/**
	 * Les champs nécessaires aux calculs pour bouger la bille sont
	 * en static car les deux classes qui héritent de celles-ci se
	 * partagent les valeurs de ces variables.
	 */
	protected static Vecteur positionSourisPressed, positionSourisActuelle, differenceSourisPressedPositionBilleInitiale;
	protected static Vecteur oldDraggedPosition, positionInitialeBille, velociteDeplacement, distanceDeplacement;
	protected static long pressedDate, actualDate, lastDraggedDate, tempsPasse;
	protected static double vitesseScalaire;

	
	public MouseEventExpertCOR(MouseEventExpertCOR m, BillePilotee bille){
		this.next = m;
		this.setBille(bille);
	}

	@Override
	public boolean traiteEvenement(MouseEvent e, ControleurEtatBillePilotee controleur) {
		boolean aReconnuEvent = this.reconnaitEvent(e, controleur);
		
		if(aReconnuEvent)
			return true;
		if(this.next != null)
			return this.next.traiteEvenement(e, controleur);
		else
			return false;
	}

	public BillePilotee getBille() {
		return bille;
	}

	public void setBille(BillePilotee bille) {
		this.bille = bille;
	}
}
