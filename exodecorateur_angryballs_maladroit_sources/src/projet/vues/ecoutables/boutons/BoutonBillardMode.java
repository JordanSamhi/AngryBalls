package projet.vues.ecoutables.boutons;

import java.awt.AWTEvent;

import projet.AnimationBilles;

public class BoutonBillardMode extends Bouton {

	private static final long serialVersionUID = 1L;

	public BoutonBillardMode(String messageBouton) {
		super(messageBouton);
	}

	@Override
	public void action(AnimationBilles animationBilles, AWTEvent e) {
		animationBilles.initBillardMode();
	}

}
