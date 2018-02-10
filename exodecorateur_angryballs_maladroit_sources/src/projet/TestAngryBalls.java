package projet;

import projet.vues.CadreAngryBalls;

public class TestAngryBalls{

	public static void main(String[] args){
		CadreAngryBalls cadre = new CadreAngryBalls(" Angry balls", " Projet Design Pattern SAMHI - ALMEFTAH - AITAAZIZE");
		cadre.montrer();
		
		AnimationBilles animationBilles = new AnimationBilles(cadre);
	}
}
