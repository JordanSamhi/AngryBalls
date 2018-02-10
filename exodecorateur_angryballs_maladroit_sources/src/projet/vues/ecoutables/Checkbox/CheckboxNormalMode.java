package projet.vues.ecoutables.Checkbox;

import java.awt.AWTEvent;

import projet.AnimationBilles;

public class CheckboxNormalMode extends CheckboxPerso {

	private static final long serialVersionUID = 1L;

	public CheckboxNormalMode(String messageCheckbox) {
		super(messageCheckbox);
	}

	@Override
	public void action(AnimationBilles animationBilles, AWTEvent e) {
		animationBilles.setNormalMode();
	}

}
