package projet;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.vues.VueBillard;

/**
 * responsable de l'animation des billes, c-�-d responsable du mouvement de la liste des billes. met perp�tuellement � jour les billes. 
 * g�re le d�lai entre 2 mises � jour (deltaT) et pr�vient la vue responsable du dessin des billes qu'il faut mettre � jour la sc�ne
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
					billeCourante.d�placer(this.getDeltaT());
					billeCourante.gestionAcc�l�ration(this.billes);
					billeCourante.gestionCollisionBilleBille(this.billes);
					billeCourante.collisionContour(0, 0, vueBillard.largeurBillard(), vueBillard.hauteurBillard());
				}
				vueBillard.miseAJour();
				Thread.sleep((int)this.getDeltaT());
			}
		}
		catch (InterruptedException e){}
	}

	static double maxVitessesCarr�es(Vector<Bille> billes){
		double vitesse2Max = 0;

		for(Bille bille : billes)
			vitesse2Max = (bille.getVitesse().normeCarr�e() > vitesse2Max) ?  bille.getVitesse().normeCarr�e() : vitesse2Max;
			
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

	public void arr�terAnimation(){
		if (thread != null){
			this.thread.interrupt();
			this.thread = null;
		}
	}
	
	public void resetAnimation(){
		this.arr�terAnimation();
		for(Bille bille : this.billes){
			bille.setPosition(Vecteur.cr�ationAl�atoire(0, 0, this.vueBillard.largeurBillard(), this.vueBillard.hauteurBillard()));
			bille.setVitesse(Vecteur.cr�ationAl�atoire(-this.getvMax(), -this.getvMax(), this.getvMax(), this.getvMax()));
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
