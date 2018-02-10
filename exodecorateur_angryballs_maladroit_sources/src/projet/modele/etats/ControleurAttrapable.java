package projet.modele.etats;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapable extends ControleurEtatBillePilotee {
	
	public ControleurAttrapable(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous){
		super(bille, next, previous);
	}

	/**
	 * Si bille attrapable, on peut juste cliquer dedans pour l'attraper
	 * On récupère la position du clic, on regarde si le clic est dans la bille,
	 * Si oui, on récupère le timestamp du clic, on stop la bille, 
	 * on récupère la position initiale de la bille, on calcul la différence
	 * entre l'endroit du clic et le centre de la bille pour avoir un mouvement
	 * plus naturel. Puis on passe au controleur suivant.
	 */
	@Override
	public void handleMousePressed(MouseEvent e){
		ControleurEtatBillePilotee.positionSourisPressed = new Vecteur(e.getX(), e.getY());
		if(this.getBille().pointIsInsideBille(ControleurEtatBillePilotee.positionSourisPressed)){
			ControleurEtatBillePilotee.positionSourisActuelle = ControleurEtatBillePilotee.positionSourisPressed;
			ControleurEtatBillePilotee.pressedDate = e.getWhen();
			ControleurEtatBillePilotee.actualDate = ControleurEtatBillePilotee.pressedDate;
			this.getBille().setVitesse(Vecteur.VECTEURNUL);
			ControleurEtatBillePilotee.positionInitialeBille = this.getBille().getPosition();
			ControleurEtatBillePilotee.differenceSourisPressedPositionBilleInitiale = ControleurEtatBillePilotee.positionSourisPressed.difference(ControleurEtatBillePilotee.positionInitialeBille);
			this.getBille().setControleurCourant(this.getNext());
			ControleurEtatBillePilotee.velociteDeplacement = new Vecteur();
		}
	}

	@Override
	public void handleMouseDragged(MouseEvent e){}

	@Override
	public void handleMouseReleased(MouseEvent e){}
	
}
