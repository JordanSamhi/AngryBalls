package projet.modele.decorateurs;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleDecorateur;
import projet.modele.etats.ControleurAttrapable;
import projet.modele.etats.ControleurAttrapee;
import projet.modele.etats.ControleurEtatBillePilotee;

public class BillePilotee extends BilleDecorateur implements MouseMotionListener{
	
	ControleurEtatBillePilotee controleurCourant;
	ControleurAttrapable controleurAttrapable;
	ControleurAttrapee controleurAttrapee;
	
	int x, y;

	public BillePilotee(Bille next) {
		super(next);
		//this.genererGrapheControleurs();
		this.addMouseMotionListener(this);
		this.setSize((int) this.getDiametre(), (int) this.getDiametre());
		this.setLocation((int) this.getPosition().x - (int) this.getRayon(), (int) this.getPosition().y - (int) this.getRayon());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void genererGrapheControleurs() {
		this.controleurAttrapable = new ControleurAttrapable(this, null, null);
		this.controleurAttrapee = new ControleurAttrapee(this, this.controleurAttrapable, this.controleurAttrapable);
		this.controleurAttrapable.setPrevious(this.controleurAttrapee);
		this.controleurAttrapable.setNext(this.controleurAttrapee);
		this.controleurCourant = this.controleurAttrapable;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		this.setPosition(this.getPosition().somme(new Vecteur(e.getX(),e.getY())));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
