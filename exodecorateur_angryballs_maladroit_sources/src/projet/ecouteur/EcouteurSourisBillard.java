package projet.ecouteur;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import projet.AnimationBilles;
import projet.modele.Bille;


public class EcouteurSourisBillard implements MouseInputListener{
	
	AnimationBilles animationBilles;

	public EcouteurSourisBillard(AnimationBilles animationBilles) {
		this.animationBilles = animationBilles;
	}

	@Override
	public void mousePressed(MouseEvent e){
		for(Bille bille : this.animationBilles.getBilles())
			bille.handleMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e){
		for(Bille bille : this.animationBilles.getBilles())
			bille.handleMouseReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e){
		for(Bille bille : this.animationBilles.getBilles())
			bille.handleMouseDragged(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mouseMoved(MouseEvent e){}
}
