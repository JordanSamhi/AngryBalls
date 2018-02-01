package exodecorateur_angryballs.maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.BilleProf;


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
	Vector<BilleProf> billes;
	
	public Billard(Vector<BilleProf> billes)
	{
		this.billes = billes;
	}
	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics)
	{
		int i;

		for ( i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graphics);

		//System.out.println("billes dans le billard = " + billes);
	}



}
