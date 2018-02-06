package projet.ecouteur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import projet.AnimationBilles;


/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurBillardMode implements ItemListener{
	AnimationBilles animationBilles;

	public EcouteurBillardMode(AnimationBilles animationBilles){
		this.animationBilles = animationBilles;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		this.animationBilles.setBillardMode();
	}

}
