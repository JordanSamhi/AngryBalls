package projet;

import projet.ecouteur.EcouteurBillardMode;
import projet.ecouteur.EcouteurBoutonArreter;
import projet.ecouteur.EcouteurBoutonLancer;
import projet.ecouteur.EcouteurBoutonReset;
import projet.ecouteur.EcouteurNormalMode;
import projet.vues.CadreAngryBalls;

public class TestAngryBalls{

	public static void main(String[] args)
	{
		CadreAngryBalls cadre = new CadreAngryBalls(" Angry balls", " Projet Design Pattern SAMHI - ALMEFTAH - AITAAZIZE");
		cadre.montrer();
		
		AnimationBilles animationBilles = new AnimationBilles(cadre);

		EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
		EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles);
		EcouteurBoutonReset �couteurBoutonReset = new EcouteurBoutonReset(animationBilles); 
		EcouteurNormalMode ecouteurNormalMode = new EcouteurNormalMode(animationBilles);
		EcouteurBillardMode ecouteurBillardMode = new EcouteurBillardMode(animationBilles);

		cadre.getLancerBilles().addActionListener(�couteurBoutonLancer);
		cadre.getArr�terBilles().addActionListener(�couteurBoutonArr�ter);
		cadre.getResetBilles().addActionListener(�couteurBoutonReset);
		cadre.getNormalMode().addItemListener(ecouteurNormalMode);
		cadre.getBillardMode().addItemListener(ecouteurBillardMode); 
	}
}
