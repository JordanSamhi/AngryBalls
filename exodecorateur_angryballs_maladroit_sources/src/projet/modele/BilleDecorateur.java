package projet.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class BilleDecorateur extends Bille {
	protected Bille next;
	
	public BilleDecorateur(Bille next) {
		this.next = next;
	}
	
	public Bille getNext() {
		return this.next;
	}
	
	@Override
	public Vecteur getPosition() {
		return this.getNext().getPosition();
	}

	@Override
	public double getRayon() {
		return this.getNext().getRayon();
	}

	@Override
	public Color getColor() {
		return this.getNext().getColor();
	}

	@Override
	public Vecteur getVitesse() {
		return this.getNext().getVitesse();
	}

	@Override
	public Vecteur getAccélération() {
		return this.getNext().getAccélération();
	}

	@Override
	public int getClef() {
		return this.getNext().getClef();
	}

	@Override
	public double masse() {
		return this.getNext().masse();
	}
	
	@Override
	public void déplacer(double deltaT) {
		this.getNext().déplacer(deltaT);
	}
	
	@Override
	public void dessine(Graphics g) {
		this.getNext().dessine(g);
	}
	
	public void setVitesse(Vecteur vitesse) {
		this.getNext().setVitesse(vitesse);
	}
	
	public void setPosition(Vecteur position) {
		this.getNext().setPosition(position);
	}
	
	public void setAcceleration(Vecteur acceleration) {
		this.getNext().setAcceleration(acceleration);
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes){
		return this.getNext().gestionCollisionBilleBille(billes);
	}
	
	public void gestionAccélération(Vector<Bille> billes) {
		this.getNext().gestionAccélération(billes);
	}
	
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		return this.getNext().collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
	public boolean pointIsInsideBille(Vecteur point) {
		return this.getNext().pointIsInsideBille(point);
	}
	
	public void handleMousePressed(MouseEvent e) {
		this.getNext().handleMousePressed(e);
	}
	
	public void handleMouseDragged(MouseEvent e) {
		this.getNext().handleMouseDragged(e);
	}
	
	public void handleMouseReleased(MouseEvent e) {
		this.getNext().handleMouseReleased(e);
	}
}
