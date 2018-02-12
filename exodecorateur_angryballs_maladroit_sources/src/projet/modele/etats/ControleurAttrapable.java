package projet.modele.etats;

import projet.modele.cor.MouseEventPressed;
import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapable extends ControleurEtatBillePilotee {
	
	/**
	 * 
	 * @param bille
	 * @param next
	 * @param previous
	 * 
	 * Ce contr�leur ne contient qu'un expert qui g�re l'event mousePressed
	 */
	public ControleurAttrapable(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous){
		super(bille, next, previous);
		this.expert = new MouseEventPressed(null, bille);
	}

}
