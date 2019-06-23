package projet.vues.ecoutables;

import java.awt.AWTEvent;

import projet.AnimationBilles;

public interface Ecoutable{
	public void action(AnimationBilles animationBilles, AWTEvent e);
	public void addListener();
}
