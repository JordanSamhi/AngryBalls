package projet.ecouteur;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import projet.vues.ecoutables.Billard;


public class EcouteurSourisBillard extends Ecouteur implements MouseInputListener{

	public EcouteurSourisBillard(Billard billard) {
		super(billard);
	}

	@Override
	public void mousePressed(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}

	@Override
	public void mouseReleased(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}

	@Override
	public void mouseDragged(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}

	@Override
	public void mouseEntered(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}

	@Override
	public void mouseExited(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}

	@Override
	public void mouseMoved(MouseEvent e){
		this.getObservable().notifyObservers(e);
	}
}
