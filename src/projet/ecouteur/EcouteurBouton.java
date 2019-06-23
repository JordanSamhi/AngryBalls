package projet.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projet.vues.ecoutables.boutons.Bouton;

public class EcouteurBouton extends Ecouteur implements ActionListener{

	public EcouteurBouton(Bouton bouton){
		super(bouton);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		this.getObservable().notifyObservers(e);
	}
}
