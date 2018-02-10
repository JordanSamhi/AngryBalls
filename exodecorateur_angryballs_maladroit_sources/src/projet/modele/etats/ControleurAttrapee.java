package projet.modele.etats;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.decorateurs.BillePilotee;

public class ControleurAttrapee extends ControleurEtatBillePilotee {

	public ControleurAttrapee(BillePilotee bille, ControleurEtatBillePilotee next, ControleurEtatBillePilotee previous) {
		super(bille, next, previous);
	}

	@Override
	public void handleMousePressed(MouseEvent e){}

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
	public void handleMouseDragged(MouseEvent e){
		ControleurEtatBillePilotee.oldDraggedPosition = ControleurEtatBillePilotee.positionSourisActuelle;
		ControleurEtatBillePilotee.lastDraggedDate = ControleurEtatBillePilotee.actualDate;
		ControleurEtatBillePilotee.positionSourisActuelle = new Vecteur(e.getX(), e.getY());
		ControleurEtatBillePilotee.actualDate = e.getWhen();
		
		ControleurEtatBillePilotee.tempsPasse = ControleurEtatBillePilotee.actualDate - ControleurEtatBillePilotee.lastDraggedDate;
		ControleurEtatBillePilotee.distanceDeplacement = ControleurEtatBillePilotee.positionSourisActuelle.difference(ControleurEtatBillePilotee.oldDraggedPosition);
		ControleurEtatBillePilotee.vitesseScalaire = ControleurEtatBillePilotee.distanceDeplacement.norme() / ControleurEtatBillePilotee.tempsPasse;
		
		if(vitesseScalaire != 0)
			ControleurEtatBillePilotee.velociteDeplacement = new Vecteur(distanceDeplacement.produit(vitesseScalaire/distanceDeplacement.norme()));
		
		if(this.bille.pointIsInsideBille(ControleurEtatBillePilotee.positionSourisActuelle)) {	
			this.bille.setPosition(ControleurEtatBillePilotee.positionSourisActuelle.difference(ControleurEtatBillePilotee.differenceSourisPressedPositionBilleInitiale));
			this.bille.setVitesse(ControleurEtatBillePilotee.velociteDeplacement);
		}else
			this.bille.setControleurCourant(this.getPrevious());
	}
	
	/**
	 * Si on lache souris, etat suivant.
	 */

	@Override
	public void handleMouseReleased(MouseEvent e){
		this.bille.setControleurCourant(getNext());
	}


}
