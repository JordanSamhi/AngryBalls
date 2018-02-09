package projet.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComponent;

import mesmaths.geometrie.base.Vecteur;

public abstract class Bille extends JComponent{
	public abstract void gestionAcc�l�ration(Vector<Bille> billes);
	public abstract Vecteur getPosition();
	public abstract double getRayon();
	public abstract Color getColor();
	public abstract Vecteur getVitesse();
	public abstract Vecteur getAcc�l�ration();
	public abstract int getClef();
	public abstract double masse();
	public abstract void d�placer( double deltaT);
	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);
	public abstract void dessine (Graphics g);
	public abstract void setVitesse(Vecteur vitesse);
	public abstract void setPosition(Vecteur position);
	public abstract void setAcceleration(Vecteur acceleration);
	
	public String toString(){
		return "centre = " + this.getPosition() + " rayon = "+ this.getRayon()+  " vitesse = " + this.getVitesse() 
		+ " acc�l�ration = " + this.getAcc�l�ration()+ " couleur = " + this.getColor() + "clef = " + this.getClef();
	}
	
	public double getDiametre() {
		return 2 * this.getRayon();
	}
}
