package projet.modele.cor;

import java.awt.event.MouseEvent;
import java.util.Vector;

import projet.modele.Bille;

public class MouseEventReleased extends MouseEventExpertCOR {

	public MouseEventReleased(MouseEventExpertCOR m, Vector<Bille> billes) {
		super(m, billes);
	}

	@Override
	public boolean reconnaitEvent(MouseEvent e) {
		if(e.getID() == MouseEvent.MOUSE_RELEASED){
			for(Bille bille : this.getBilles())
					bille.handleMouseReleased(e);
			return true;
		}
		return false;
	}

}
