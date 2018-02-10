package projet.vues;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import projet.modele.Bille;


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
	}

}
