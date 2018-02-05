package projet;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.vues.VueBillard;

/**
 * responsable de l'animation des billes, c-à-d responsable du mouvement de la liste des billes. met perpétuellement à jour les billes. 
 * gère le délai entre 2 mises à jour (deltaT) et prévient la vue responsable du dessin des billes qu'il faut mettre à jour la scène
 * 
 * ICI : IL N'Y A RIEN A CHANGER j
 * */
public class AnimationBilles  implements Runnable{

	Vector<Bille> billes; 
	VueBillard vueBillard;
	private Thread thread;
	private final double deltaT = 1;
	private final double vMax = 0.1;

	public AnimationBilles(Vector<Bille> billes, VueBillard vueBillard){
		this.billes = billes;
		this.vueBillard = vueBillard;
		this.thread = null;
	}

	public void run(){
		try{
			while (!Thread.interrupted()){
				for(Bille billeCourante : this.billes){
					billeCourante.déplacer(this.getDeltaT());
					billeCourante.gestionAccélération(this.billes);
					billeCourante.gestionCollisionBilleBille(this.billes);
					billeCourante.collisionContour(0, 0, vueBillard.largeurBillard(), vueBillard.hauteurBillard());
				}
				vueBillard.miseAJour();
				Thread.sleep((int)this.getDeltaT());
			}
		}
		catch (InterruptedException e){}
	}

	static double maxVitessesCarrées(Vector<Bille> billes){
		double vitesse2Max = 0;

		for(Bille bille : billes)
			vitesse2Max = (bille.getVitesse().normeCarrée() > vitesse2Max) ?  bille.getVitesse().normeCarrée() : vitesse2Max;
			
		return vitesse2Max;
	}

	static double minRayons(Vector<Bille> billes){
		double rayonMin;
		rayonMin = Double.MAX_VALUE;
		
		for(Bille bille : billes)
			rayonMin = (bille.getRayon() < rayonMin) ? bille.getRayon() : rayonMin;
			
		return rayonMin;
	}


	public void lancerAnimation(){
		if (this.thread == null){ 
			this.thread = new Thread(this);
			thread.start();
		}
	}

	public void arrêterAnimation(){
		if (thread != null){
			this.thread.interrupt();
			this.thread = null;
		}
	}
	
	public void resetAnimation(){
		this.arrêterAnimation();
		for(Bille bille : this.billes){
			bille.setPosition(Vecteur.créationAléatoire(0, 0, this.vueBillard.largeurBillard(), this.vueBillard.hauteurBillard()));
			bille.setVitesse(Vecteur.créationAléatoire(-this.getvMax(), -this.getvMax(), this.getvMax(), this.getvMax()));
			bille.setAcceleration(new Vecteur());
		}
		this.lancerAnimation();
	}

	public double getDeltaT() {
		return this.deltaT;
	}

	public double getvMax() {
		return vMax;
	}
}
