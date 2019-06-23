package projet.vues.ecoutables.Checkbox;

import java.awt.AWTEvent;
import java.awt.Checkbox;
import java.util.Vector;

import projet.ecouteur.EcouteurCheckbox;
import projet.vues.Observable;
import projet.vues.Observateur;
import projet.vues.ecoutables.Ecoutable;

public abstract class CheckboxPerso extends Checkbox implements Ecoutable, Observable {

	private static final long serialVersionUID = 1L;
	private Vector<Observateur> observers;

	public CheckboxPerso(String messageCheckbox){
		super(messageCheckbox);
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
		this.addItemListener(new EcouteurCheckbox(this));
	}

}
