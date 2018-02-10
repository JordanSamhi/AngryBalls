package projet.modele.etats;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;

public abstract class ControleurEtatBillePilotee {
	
	protected ControleurEtatBillePilotee next, previous;
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
	
	public BillePilotee getBille() {
		return bille;
	}

	public abstract void handleMousePressed(MouseEvent e);
	public abstract void handleMouseDragged(MouseEvent e);
	public abstract void handleMouseReleased(MouseEvent e);
	
}
