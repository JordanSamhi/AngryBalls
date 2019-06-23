package projet.vues;

import java.awt.AWTEvent;

public interface Observable {
	public void addObserver(Observateur o);
	public void notifyObservers(AWTEvent e);
}
