package projet.modele.cor;

import java.awt.event.MouseEvent;
import java.util.Vector;

import projet.modele.Bille;

public class MouseEventPressed extends MouseEventExpertCOR {

	public MouseEventPressed(MouseEventExpertCOR m, Vector<Bille> billes) {
		super(m, billes);
	}

	@Override
	public boolean reconnaitEvent(MouseEvent e) {
		if(e.getID() == MouseEvent.MOUSE_PRESSED){
			for(Bille bille : this.getBilles())
					bille.handleMousePressed(e);
			return true;
		}
		return false;
	}
}
