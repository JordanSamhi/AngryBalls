package src.projet.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.projet.AnimationBilles;

/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */
public class EcouteurBoutonLancer implements ActionListener
{
	AnimationBilles animationBilles;



	/**
	 * @param animationsBilles
	 */
	public EcouteurBoutonLancer(AnimationBilles animationBilles)
	{
		this.animationBilles = animationBilles;
	}



	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.animationBilles.lancerAnimation();
	}

}
