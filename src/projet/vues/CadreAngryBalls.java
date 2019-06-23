package projet.vues;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projet.AnimationBilles;
import projet.modele.Bille;
import projet.outilsvues.EcouteurTerminaison;
import projet.outilsvues.Outils;
import projet.vues.ecoutables.Billard;
import projet.vues.ecoutables.Ecoutable;
import projet.vues.ecoutables.Checkbox.CheckboxBillardMode;
import projet.vues.ecoutables.Checkbox.CheckboxNormalMode;
import projet.vues.ecoutables.Checkbox.CheckboxPerso;
import projet.vues.ecoutables.boutons.Bouton;
import projet.vues.ecoutables.boutons.BoutonArreter;
import projet.vues.ecoutables.boutons.BoutonBillardMode;
import projet.vues.ecoutables.boutons.BoutonLancer;
import projet.vues.ecoutables.boutons.BoutonMuteUnMute;
import projet.vues.ecoutables.boutons.BoutonNormalMode;
import projet.vues.ecoutables.boutons.BoutonReset;
/**
 * Vue dessinant les billes et contenant les 3 boutons de contrôle (arrêt du programme, lancer les billes, arréter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls extends JFrame implements VueBillard, Observateur{
	private static final long serialVersionUID = 1L;
	private JLabel messageAccueilProjet, messageAccueilNoms, messageAccueilTitre;
	private Billard billard;
	private Bouton lancerBilles, arreterBilles, resetBilles, normalModeButton, billardModeButton, muteUnMuteBouton;
	private JPanel haut, centre, bas, basButtons, basCheckBox;
	private CheckboxGroup choixTypeVue;
	private CheckboxPerso normalMode, billardMode;
	private AnimationBilles animationBilles;

	EcouteurTerminaison ecouteurTerminaison;

	public CadreAngryBalls(String titre, String message1, String message2) throws HeadlessException{
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
		
		this.billard = new Billard();
		this.billard.addObserver(this);
		this.billard.setLayout(new GridLayout(3, 1));
		this.getContentPane().add(this.billard);
		
		this.messageAccueilProjet = new JLabel(message1, JLabel.CENTER);
		this.messageAccueilProjet.setFont(new Font("arial", Font.BOLD, 50));
		this.billard.add(this.messageAccueilProjet);
		
		this.messageAccueilTitre = new JLabel(titre, JLabel.CENTER);
		this.messageAccueilTitre.setFont(new Font("arial", Font.BOLD, 40));
		this.billard.add(this.messageAccueilTitre);
		
		this.messageAccueilNoms = new JLabel(message2, JLabel.CENTER);
		this.messageAccueilNoms.setFont(new Font("arial", Font.BOLD, 25));
		this.billard.add(this.messageAccueilNoms);
		
		this.basButtons = new JPanel();
		this.basButtons.setBackground(Color.LIGHT_GRAY);
		this.bas.add(this.basButtons, BorderLayout.NORTH);
		
		this.lancerBilles = new BoutonLancer("Lancer les billes");
		this.lancerBilles.addObserver(this);
		
		this.arreterBilles = new BoutonArreter("Arrêter les billes");
		this.arreterBilles.addObserver(this);
		
		this.resetBilles = new BoutonReset("Reset scene");
		this.resetBilles.addObserver(this);
		
		this.muteUnMuteBouton = new BoutonMuteUnMute("Couper/Mettre le son");
		this.muteUnMuteBouton.addObserver(this);
		
		this.normalModeButton = new BoutonNormalMode("Mode normal");
		this.normalModeButton.addObserver(this);
		
		this.billardModeButton = new BoutonBillardMode("Mode billard");
		this.billardModeButton.addObserver(this);
		
		this.normalMode = new CheckboxNormalMode("Mode normal");
		this.normalMode.addObserver(this);
		
		this.billardMode = new CheckboxBillardMode("Mode Billard");
		this.billardMode.addObserver(this);
		
		this.choixTypeVue = new CheckboxGroup();
		this.normalMode.setCheckboxGroup(choixTypeVue);
		this.billardMode.setCheckboxGroup(choixTypeVue);
		
		this.basCheckBox = new JPanel();
		this.basCheckBox.setBackground(Color.LIGHT_GRAY);
		
		this.bas.add(this.basCheckBox, BorderLayout.SOUTH);
		
		this.basButtons.add(this.arreterBilles);
		this.basButtons.add(this.lancerBilles);
		this.basButtons.add(this.resetBilles);
		this.basButtons.add(muteUnMuteBouton);
		this.basCheckBox.add(this.normalModeButton);
		this.basCheckBox.add(this.billardModeButton);
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

	public Billard getBillard() {
		return billard;
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
	
	@Override
	public void setBackgroundColor(Color c) {
		this.billard.setBackground(c);
	}

	@Override
	public void update(Ecoutable ecoutable, AWTEvent e) {
		ecoutable.action(this.animationBilles, e);
	}

	@Override
	public void setAnimationBilles(AnimationBilles animationBilles) {
		this.animationBilles = animationBilles;
	}

	@Override
	public void switchButtons(){
		this.basCheckBox.remove(billardModeButton);
		this.basCheckBox.remove(normalModeButton);
		this.billard.remove(messageAccueilNoms);
		this.billard.remove(messageAccueilTitre);
		this.billard.remove(messageAccueilProjet);
		this.basCheckBox.add(this.normalMode);
		this.basCheckBox.add(this.billardMode);
		this.bas.revalidate();
	}

	@Override
	public void checkNormalRadio() {
		this.normalMode.setState(true);
	}

	@Override
	public void checkBillardRadio() {
		this.billardMode.setState(true);
	}
}