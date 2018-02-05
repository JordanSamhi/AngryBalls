package projet.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projet.AnimationBilles;

public class EcouteurBoutonReset implements ActionListener{
	AnimationBilles animationBilles;

	public EcouteurBoutonReset(AnimationBilles animationBilles){
		this.animationBilles = animationBilles;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		this.animationBilles.resetAnimation();
	}

}
