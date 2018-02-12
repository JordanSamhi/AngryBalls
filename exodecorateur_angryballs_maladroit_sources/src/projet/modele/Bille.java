package projet.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class Bille{
	public abstract void gestionAcc�l�ration(Vector<Bille> billes);
	public abstract Vecteur getPosition();
	public abstract double getRayon();
	public abstract Color getColor();
	public abstract Vecteur getVitesse();
	public abstract Vecteur getAcc�l�ration();
	public abstract int getClef();
	public abstract double masse();
	public abstract void d�placer( double deltaT);
	public abstract Vecteur gestionCollisionBilleBille(Vector<Bille> billes);
	public abstract boolean collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);
	public abstract void dessine (Graphics g);
	public abstract void setVitesse(Vecteur vitesse);
	public abstract void setPosition(Vecteur position);
	public abstract void setAcceleration(Vecteur acceleration);
	public abstract boolean pointIsInsideBille(Vecteur point);
	public abstract void handleMouseEvent(MouseEvent e);
	
	public String toString(){
		return "centre = " + this.getPosition() + " rayon = "+ this.getRayon()+  " vitesse = " + this.getVitesse() 
		+ " acc�l�ration = " + this.getAcc�l�ration()+ " couleur = " + this.getColor() + "clef = " + this.getClef();
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
