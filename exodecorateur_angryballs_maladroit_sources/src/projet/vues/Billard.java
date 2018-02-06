package projet.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import projet.modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
	private static final long serialVersionUID = 1L;
	private Vector<Bille> billes;
	
	public Billard(Vector<Bille> billes) {
		this.billes = billes;
	}
	
	@Override
	public void paint(Graphics graphics){
		for(Bille bille : this.billes)
			bille.dessine(graphics);
	}
	
	public void setBilles(Vector<Bille> billes) {
		this.billes = billes;
	}
}
