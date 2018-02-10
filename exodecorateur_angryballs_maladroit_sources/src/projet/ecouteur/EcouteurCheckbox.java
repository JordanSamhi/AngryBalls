package projet.ecouteur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import projet.vues.ecoutables.Checkbox.CheckboxPerso;

public class EcouteurCheckbox extends Ecouteur implements ItemListener {

	public EcouteurCheckbox(CheckboxPerso checkbox) {
		super(checkbox);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.getObservable().notifyObservers(e);
	}

}
