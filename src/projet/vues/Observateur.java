package projet.vues;

import java.awt.AWTEvent;

import projet.vues.ecoutables.Ecoutable;

public interface Observateur {
	public void update(Ecoutable ecoutable, AWTEvent e);
}
