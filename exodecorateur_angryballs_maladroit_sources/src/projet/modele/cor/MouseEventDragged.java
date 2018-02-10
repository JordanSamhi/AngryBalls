package projet.modele.cor;

import java.awt.event.MouseEvent;
import java.util.Vector;

import projet.modele.Bille;

public class MouseEventDragged extends MouseEventExpertCOR {

	public MouseEventDragged(MouseEventExpertCOR m, Vector<Bille> billes) {
		super(m, billes);
	}

	@Override
	public boolean reconnaitEvent(MouseEvent e) {
		if(e.getID() == MouseEvent.MOUSE_DRAGGED){
			for(Bille bille : this.getBilles())
					bille.handleMouseDragged(e);
			return true;
		}
		return false;
	}

}
