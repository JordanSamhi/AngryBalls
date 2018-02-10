package projet.modele.cor;

import java.awt.event.MouseEvent;
import java.util.Vector;

import projet.modele.Bille;

public abstract class MouseEventExpertCOR implements MouseEventExpert {
	
	private MouseEventExpertCOR next;
	private Vector<Bille> billes;

	public MouseEventExpertCOR(MouseEventExpertCOR m, Vector<Bille> billes){
		this.next = m;
		this.setBilles(billes);
	}

	@Override
	public boolean traiteEvenement(MouseEvent e) {
		boolean aReconnuEvent = this.reconnaitEvent(e);
		
		if(aReconnuEvent)
			return true;
		if(this.next != null)
			return this.next.traiteEvenement(e);
		else
			return false;
	}

	public Vector<Bille> getBilles() {
		return billes;
	}

	public void setBilles(Vector<Bille> billes) {
		this.billes = billes;
	}
}
