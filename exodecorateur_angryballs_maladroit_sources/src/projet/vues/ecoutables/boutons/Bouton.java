package projet.vues.ecoutables.boutons;

import java.awt.AWTEvent;
import java.util.Vector;

import javax.swing.JButton;

import projet.ecouteur.EcouteurBouton;
import projet.vues.Observable;
import projet.vues.Observateur;
import projet.vues.ecoutables.Ecoutable;

public abstract class Bouton extends JButton implements Ecoutable, Observable{

	private static final long serialVersionUID = 1L;
	
	Vector<Observateur> observers;

	public Bouton(String messageBouton) {
		super(messageBouton);
		this.addListener();
		this.observers = new Vector<Observateur>();
	}
	
	@Override
	public void addObserver(Observateur o){
		this.observers.add(o);
	}

	@Override
	public void notifyObservers(AWTEvent e){
		for(Observateur o : this.observers)
			o.update(this, e);
	}
	
	public void addListener() {
		this.addActionListener(new EcouteurBouton(this));
	}
}
