package projet.vues;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Vector;

import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;
import projet.modele.Bille;
/**
 * Vue dessinant les billes et contenant les 3 boutons de contrôle (arrêt du programme, lancer les billes, arréter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls extends Frame implements VueBillard{
	private static final long serialVersionUID = 1L;
	TextField présentation;
	Billard billard;
	public Button lancerBilles, arrêterBilles, resetBilles;
	Panel haut, centre, bas, basButtons, basCheckBox;
	private CheckboxGroup choixTypeVue;
	public Checkbox normalMode, billardMode;

	EcouteurTerminaison ecouteurTerminaison;

	public CadreAngryBalls(String titre, String message) throws HeadlessException{
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);
		this.ecouteurTerminaison = new EcouteurTerminaison(this);

		this.haut = new Panel(); this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut,BorderLayout.NORTH);

		this.centre = new Panel();
		this.add(this.centre,BorderLayout.CENTER);

		this.bas = new Panel(); this.bas.setBackground(Color.LIGHT_GRAY);
		this.bas.setLayout(new BorderLayout());
		this.add(this.bas,BorderLayout.SOUTH);
		
		this.présentation = new TextField(message, 41);
		this.présentation.setEditable(false);
		this.haut.add(this.présentation);
		
		this.billard = new Billard();
		this.add(this.billard);

		this.basButtons = new Panel();
		this.basButtons.setBackground(Color.LIGHT_GRAY);
		this.bas.add(this.basButtons, BorderLayout.NORTH);
		this.lancerBilles = new Button("lancer les billes");
		this.arrêterBilles = new Button("arrêter les billes");
		this.resetBilles = new Button("reset scene");
		this.resetBilles.setEnabled(false);
		this.basButtons.add(this.arrêterBilles);
		this.basButtons.add(this.lancerBilles);
		this.basButtons.add(this.resetBilles);

		this.choixTypeVue = new CheckboxGroup(); 
		this.normalMode = new Checkbox("Mode normal");
		this.billardMode = new Checkbox("Mode Billard");
		this.normalMode.setCheckboxGroup(choixTypeVue);
		this.billardMode.setCheckboxGroup(choixTypeVue);
		this.basCheckBox = new Panel();
		this.basCheckBox.setBackground(Color.LIGHT_GRAY);
		this.basCheckBox.add(this.normalMode);
		this.basCheckBox.add(this.billardMode);
		this.bas.add(this.basCheckBox, BorderLayout.SOUTH);
		

	}

	public double largeurBillard() {
		return this.billard.getWidth();
	}

	public double hauteurBillard(){
		return this.billard.getHeight();
	}

	@Override
	public void miseAJour(){
		this.billard.repaint();
	}

	@Override
	public void montrer(){
		this.setVisible(true);
	}

	@Override
	public void setBillardBilles(Vector<Bille> billes) {
		this.billard.setBilles(billes);
	}

	@Override
	public void enableResetButton() {
		this.resetBilles.setEnabled(true);
	}

	@Override
	public boolean isDisabledResetButton() {
		return !this.resetBilles.isEnabled();
	}
}