package projet.modele.mode;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.vues.VueBillard;

public abstract class Mode {
	protected Vector<Bille> billes;
	protected double xMax, yMax;
	protected double vMax;
	protected double rayon;
	protected double diametre;
	protected Vecteur pesanteur;
	
	public Mode(){
		this.billes = new Vector<Bille>();
		this.vMax = 0.1;
		this.pesanteur = new Vecteur(0,0.001);
	}
	
	public Vector<Bille> getBilles() {
		return this.billes;
	}

	public void genererBilles(VueBillard vueBillard) {
		this.xMax = vueBillard.largeurBillard();
		this.yMax = vueBillard.hauteurBillard();
		this.rayon = 0.05 * Math.min(xMax, yMax);
		this.diametre = 2 * rayon;
		
		this.billes.clear();
		this.preparerBilles();
	}
	
	protected abstract void preparerBilles();
}
