package projet.modele.cor;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;
import projet.modele.etats.ControleurEtatBillePilotee;

public class MouseEventDragged extends MouseEventExpertCOR {

	public MouseEventDragged(MouseEventExpertCOR m, BillePilotee bille) {
		super(m, bille);
	}

	/**
	 * Une fois la bille attrap�e, on peut la bouger
	 * On r�cup�re les anciennes positions et dernier timestamp
	 * Calcul du temps ==> puis de la distance ==> donc de la vitesse
	 * La vitesse �tant un scalaire, nous avons besoin de la v�locit�,
	 * C'est un vecteur avec une amplitude qui repr�sente la vitesse
	 * et une direction, c'est la direction de la vitesse.
	 * Elle se calcul ainsi : (vitesse/distance) x vecteur de d�placement
	 * On assigne la vitesse � la bille lors du d�placement pour les collisions
	 * Si lorsqu'on attrape la bille, on sort de la bille (mouvement brusque souris)
	 * alors la bille n'est plus attrap� mais change d'�tat sinon non naturel
	 */
	@Override
	public boolean reconnaitEvent(MouseEvent e, ControleurEtatBillePilotee controleur) {
		if(e.getID() == MouseEvent.MOUSE_DRAGGED){
			MouseEventExpertCOR.oldDraggedPosition = MouseEventExpertCOR.positionSourisActuelle;
			MouseEventExpertCOR.lastDraggedDate = MouseEventExpertCOR.actualDate;
			MouseEventExpertCOR.positionSourisActuelle = new Vecteur(e.getX(), e.getY());
			MouseEventExpertCOR.actualDate = e.getWhen();
			
			MouseEventExpertCOR.tempsPasse = MouseEventExpertCOR.actualDate - MouseEventExpertCOR.lastDraggedDate;
			MouseEventExpertCOR.distanceDeplacement = MouseEventExpertCOR.positionSourisActuelle.difference(MouseEventExpertCOR.oldDraggedPosition);
			MouseEventExpertCOR.vitesseScalaire = MouseEventExpertCOR.distanceDeplacement.norme() / MouseEventExpertCOR.tempsPasse;
			
			if(MouseEventExpertCOR.vitesseScalaire != 0)
				MouseEventExpertCOR.velociteDeplacement = new Vecteur(distanceDeplacement.produit(vitesseScalaire/distanceDeplacement.norme()));
			
			if(this.getBille().pointIsInsideBille(MouseEventExpertCOR.positionSourisActuelle)) {	
				this.getBille().setPosition(MouseEventExpertCOR.positionSourisActuelle.difference(MouseEventExpertCOR.differenceSourisPressedPositionBilleInitiale));
				this.getBille().setVitesse(MouseEventExpertCOR.velociteDeplacement);
			}else
				this.getBille().setControleurCourant(controleur.getPrevious());
			return true;
		}
		return false;
	}

}
