package projet;

import projet.ecouteur.EcouteurBillardMode;
import projet.ecouteur.EcouteurBoutonArreter;
import projet.ecouteur.EcouteurBoutonLancer;
import projet.ecouteur.EcouteurBoutonReset;
import projet.ecouteur.EcouteurNormalMode;
import projet.modele.mode.Mode;
import projet.modele.mode.NormalMode;
import projet.vues.CadreAngryBalls;

public class TestAngryBalls{

	public static void main(String[] args)
	{
		Mode mode = new NormalMode();
		CadreAngryBalls cadre = new CadreAngryBalls(" Angry balls", " Projet Design Pattern SAMHI - ALMEFTAH - AITAAZIZE", mode.getBilles());
		cadre.montrer();
		mode.genererBilles(cadre);
		
		AnimationBilles animationBilles = new AnimationBilles(mode, cadre);

		EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
		EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);
		EcouteurBoutonReset écouteurBoutonReset = new EcouteurBoutonReset(animationBilles); 
		EcouteurNormalMode ecouteurNormalMode = new EcouteurNormalMode(animationBilles);
		EcouteurBillardMode ecouteurBillardMode = new EcouteurBillardMode(animationBilles);

		cadre.lancerBilles.addActionListener(écouteurBoutonLancer);
		cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);
		cadre.resetBilles.addActionListener(écouteurBoutonReset);
		cadre.normalMode.addItemListener(ecouteurNormalMode);
		cadre.billardMode.addItemListener(ecouteurBillardMode);
	}
}
