package projet.vues.ecoutables;

import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;

import projet.AnimationBilles;
import projet.ecouteur.EcouteurSourisBillard;
import projet.modele.Bille;
import projet.modele.cor.MouseEventDragged;
import projet.modele.cor.MouseEventExpertCOR;
import projet.modele.cor.MouseEventPressed;
import projet.modele.cor.MouseEventReleased;
import projet.vues.Observable;
import projet.vues.Observateur;


public class Billard extends JPanel implements Ecoutable, Observable{
	private static final long serialVersionUID = 1L;
	private Vector<Bille> billes;
	private Vector<Observateur> observers;
	private MouseEventExpertCOR expert;
	
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
		this.initExperts();		
		this.expert.traiteEvenement((MouseEvent) e);
	}

	private void initExperts() {
		this.expert = new MouseEventPressed(null, this.getBilles());
		this.expert = new MouseEventReleased(this.expert, this.getBilles());
		this.expert = new MouseEventDragged(this.expert, this.getBilles());
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
