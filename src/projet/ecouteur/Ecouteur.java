package projet.ecouteur;

import projet.vues.Observable;

public abstract class Ecouteur {

	private Observable observable;

	public Ecouteur(Observable observable) {
		this.observable = observable;
	}
	public Observable getObservable() {
		return this.observable;
	}
}
