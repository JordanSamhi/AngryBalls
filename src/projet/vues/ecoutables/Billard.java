package projet.vues.ecoutables;

import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;

import projet.AnimationBilles;
import projet.ecouteur.EcouteurSourisBillard;
import projet.modele.Bille;
import projet.vues.Observable;
import projet.vues.Observateur;


public class Billard extends JPanel implements Ecoutable, Observable{
	private static final long serialVersionUID = 1L;
	private Vector<Bille> billes;
	private Vector<Observateur> observers;
	
	public Billard() {
		super();
		this.billes = new Vector<Bille>();
		this.observers = new Vector<Observateur>();
		this.addListener();
	}
	
	@Override
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		for(Bille bille : this.billes)
			bille.dessine(graphics);
	}
	
	public void setBilles(Vector<Bille> billes) {
		this.billes = billes;
	}

	public Vector<Bille> getBilles() {
		return billes;
	}

	@Override
	public void action(AnimationBilles animationBilles, AWTEvent e) {
		for(Bille bille : this.getBilles())
			bille.handleMouseEvent((MouseEvent) e);
	}

	@Override
	public void addListener() {
		EcouteurSourisBillard ecouteur = new EcouteurSourisBillard(this);
		this.addMouseListener(ecouteur);
		this.addMouseMotionListener(ecouteur);
	}

	@Override
	public void notifyObservers(AWTEvent e) {
		for(Observateur o : this.observers)
			o.update(this, e);
	}

	@Override
	public void addObserver(Observateur o) {
		this.observers.add(o);
	}

}
