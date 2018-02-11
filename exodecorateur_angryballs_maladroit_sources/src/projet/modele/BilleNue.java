package projet.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleNue extends Bille {
	public  Vecteur position;
	public  double rayon;
	public  Vecteur vitesse;
	public  Vecteur acc�l�ration;
	public int clef;
	private Color couleur;
	private static int prochaineClef = 0;
	public static double ro = 1;

	public BilleNue(Vecteur centre, double rayon, Color couleur){
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = new Vecteur();;
		this.acc�l�ration = new Vecteur();
		this.couleur = couleur;
		this.clef = BilleNue.prochaineClef ++;
	}

	public Vecteur getPosition(){
		return this.position;
	}

	public double getRayon(){
		return this.rayon;
	}

	public Vecteur getVitesse(){
		return this.vitesse;
	}

	public Vecteur getAcc�l�ration(){
		return this.acc�l�ration;
	}

	public int getClef(){
		return this.clef;
	}

	public double masse(){
		return ro*Geop.volumeSph�re(rayon);
	}

	public  void  d�placer( double deltaT){
		Cinematique.mouvementUniform�mentAcc�l�r�( this.getPosition(), this.getVitesse(), this.getAcc�l�ration(), deltaT);
	}

	public void gestionAcc�l�ration(Vector<Bille> billes){
		this.getAcc�l�ration().set(new Vecteur());
	}

	public void dessine (Graphics g){
		int width, height;
		int xMin, yMin;
		xMin = (int)Math.round(position.x-rayon);
		yMin = (int)Math.round(position.y-rayon);

		width = height = 2*(int)Math.round(rayon); 

		g.setColor(couleur);
		g.fillOval( xMin, yMin, width, height);
		g.drawOval(xMin, yMin, width, height);
	}

	@Override
	public Color getColor() {
		return this.couleur;
	}

	@Override
	public Vecteur gestionCollisionBilleBille(Vector<Bille> billes){
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	@Override
	public boolean collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur){
		return false;
	}

	@Override
	public void setVitesse(Vecteur vitesse) {
		this.vitesse = vitesse;
	}

	@Override
	public void setPosition(Vecteur position) {
		this.position = position;
	}

	@Override
	public void setAcceleration(Vecteur acceleration) {
		this.acc�l�ration = acceleration;
	}

	@Override
	public boolean pointIsInsideBille(Vecteur point) {
		double distance = Math.sqrt(Math.pow(point.x - this.getPosition().x, 2) + Math.pow(point.y - this.getPosition().y, 2));
		return distance < this.getRayon();
	}

	@Override
	public void handleMousePressed(MouseEvent e) {
		// Do nothing
	}

	@Override
	public void handleMouseDragged(MouseEvent e) {
		// Do nothing
	}

	@Override
	public void handleMouseReleased(MouseEvent e) {
		// Do nothing
	}
}
