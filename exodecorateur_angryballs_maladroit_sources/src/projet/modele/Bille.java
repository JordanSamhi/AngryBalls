package projet.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class Bille{
	public abstract void gestionAccélération(Vector<Bille> billes);
	public abstract Vecteur getPosition();
	public abstract double getRayon();
	public abstract Color getColor();
	public abstract Vecteur getVitesse();
	public abstract Vecteur getAccélération();
	public abstract int getClef();
	public abstract double masse();
	public abstract void déplacer( double deltaT);
	public abstract Vecteur gestionCollisionBilleBille(Vector<Bille> billes);
	public abstract boolean collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);
	public abstract void dessine (Graphics g);
	public abstract void setVitesse(Vecteur vitesse);
	public abstract void setPosition(Vecteur position);
	public abstract void setAcceleration(Vecteur acceleration);
	public abstract boolean pointIsInsideBille(Vecteur point);
	public abstract void handleMouseEvent(MouseEvent e);
	
	public String toString(){
		return "centre = " + this.getPosition() + " rayon = "+ this.getRayon()+  " vitesse = " + this.getVitesse() 
		+ " accélération = " + this.getAccélération()+ " couleur = " + this.getColor() + "clef = " + this.getClef();
	}
	
	public double getDiametre() {
		return 2 * this.getRayon();
	}
	public double getSide(double width){
		double xPosition = this.getPosition().x;
		if(xPosition < width)
			return -1 + (xPosition / (width / 2));
		return ((2 * xPosition) / width) - 1;
	}
}
