package projet.vues;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

import projet.modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends JPanel{
	private static final long serialVersionUID = 1L;
	private Vector<Bille> billes;
	
	public Billard() {
		super();
		this.billes = new Vector<Bille>();
	}
	
	@Override
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		for(Bille bille : this.billes)
			bille.dessine(graphics);
	}
	
	public void setBilles(Vector<Bille> billes) {
		this.billes = billes;
		for(Bille bille : this.billes)
			this.add(bille);
	}
}
