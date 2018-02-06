package projet.ecouteur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import projet.AnimationBilles;


/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurNormalMode implements ItemListener{
	AnimationBilles animationBilles;

	public EcouteurNormalMode(AnimationBilles animationBilles){
		this.animationBilles = animationBilles;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.animationBilles.setNormalMode();		
	}

}
