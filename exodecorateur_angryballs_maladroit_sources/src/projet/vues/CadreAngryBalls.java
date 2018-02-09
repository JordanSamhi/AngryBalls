package projet.vues;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;
import projet.modele.Bille;
/**
 * Vue dessinant les billes et contenant les 3 boutons de contr�le (arr�t du programme, lancer les billes, arr�ter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls extends JFrame implements VueBillard{
	private static final long serialVersionUID = 1L;
	private JTextField pr�sentation;
	private Billard billard;
	private JButton lancerBilles, arr�terBilles, resetBilles;
	private JPanel haut, centre, bas, basButtons, basCheckBox;
	private CheckboxGroup choixTypeVue;
	private Checkbox normalMode, billardMode;

	EcouteurTerminaison ecouteurTerminaison;

	public CadreAngryBalls(String titre, String message) throws HeadlessException{
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);
		this.ecouteurTerminaison = new EcouteurTerminaison(this);

		this.haut = new JPanel(); this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut,BorderLayout.NORTH);

		this.centre = new JPanel();
		this.add(this.centre,BorderLayout.CENTER);

		this.bas = new JPanel(); this.bas.setBackground(Color.LIGHT_GRAY);
		this.bas.setLayout(new BorderLayout());
		this.add(this.bas,BorderLayout.SOUTH);
		
		this.pr�sentation = new JTextField(message, 41);
		this.pr�sentation.setEditable(false);
		this.haut.add(this.pr�sentation);
		
		this.billard = new Billard();
		this.add(this.billard);

		this.basButtons = new JPanel();
		this.basButtons.setBackground(Color.LIGHT_GRAY);
		this.bas.add(this.basButtons, BorderLayout.NORTH);
		this.lancerBilles = new JButton("lancer les billes");
		this.arr�terBilles = new JButton("arr�ter les billes");
		this.resetBilles = new JButton("reset scene");
		this.resetBilles.setEnabled(false);
		this.basButtons.add(this.arr�terBilles);
		this.basButtons.add(this.lancerBilles);
		this.basButtons.add(this.resetBilles);

		this.choixTypeVue = new CheckboxGroup(); 
		this.normalMode = new Checkbox("Mode normal");
		this.billardMode = new Checkbox("Mode Billard");
		this.normalMode.setCheckboxGroup(choixTypeVue);
		this.billardMode.setCheckboxGroup(choixTypeVue);
		this.basCheckBox = new JPanel();
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

	public JTextField getPr�sentation() {
		return pr�sentation;
	}

	public Billard getBillard() {
		return billard;
	}

	public JButton getLancerBilles() {
		return lancerBilles;
	}

	public JButton getArr�terBilles() {
		return arr�terBilles;
	}

	public JButton getResetBilles() {
		return resetBilles;
	}

	public JPanel getHaut() {
		return haut;
	}

	public JPanel getCentre() {
		return centre;
	}

	public JPanel getBas() {
		return bas;
	}

	public JPanel getBasButtons() {
		return basButtons;
	}

	public JPanel getBasCheckBox() {
		return basCheckBox;
	}

	public CheckboxGroup getChoixTypeVue() {
		return choixTypeVue;
	}

	public Checkbox getNormalMode() {
		return normalMode;
	}

	public Checkbox getBillardMode() {
		return billardMode;
	}
	
	
}