package projet.modele.cor;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;
import projet.modele.etats.ControleurEtatBillePilotee;

public class MouseEventPressed extends MouseEventExpertCOR {

	public MouseEventPressed(MouseEventExpertCOR m, BillePilotee bille) {
		super(m, bille);
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
	public boolean reconnaitEvent(MouseEvent e, ControleurEtatBillePilotee controleur) {
		if(e.getID() == MouseEvent.MOUSE_PRESSED){
			MouseEventExpertCOR.positionSourisPressed = new Vecteur(e.getX(), e.getY());
			if(this.getBille().pointIsInsideBille(MouseEventExpertCOR.positionSourisPressed)){
				MouseEventExpertCOR.positionSourisActuelle = MouseEventExpertCOR.positionSourisPressed;
				MouseEventExpertCOR.pressedDate = e.getWhen();
				MouseEventExpertCOR.actualDate = MouseEventExpertCOR.pressedDate;
				this.getBille().setVitesse(new Vecteur());
				MouseEventExpertCOR.positionInitialeBille = this.getBille().getPosition();
				MouseEventExpertCOR.differenceSourisPressedPositionBilleInitiale = MouseEventExpertCOR.positionSourisPressed.difference(MouseEventExpertCOR.positionInitialeBille);
				this.getBille().setControleurCourant(controleur.getNext());
				MouseEventExpertCOR.velociteDeplacement = new Vecteur();
			}
			return true;
		}
		return false;
	}
}

