package projet.modele.cor;

import java.awt.event.MouseEvent;

import projet.modele.etats.ControleurEtatBillePilotee;

public interface MouseEventExpert {
	public boolean traiteEvenement(MouseEvent e, ControleurEtatBillePilotee controleur);
	public boolean reconnaitEvent(MouseEvent e, ControleurEtatBillePilotee controleur);
}
