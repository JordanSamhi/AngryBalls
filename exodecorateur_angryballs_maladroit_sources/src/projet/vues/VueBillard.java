package projet.vues;

import java.awt.Color;
import java.util.Vector;

import projet.AnimationBilles;
import projet.modele.Bille;

/**
 * contrat respecté par toute vue capable de dessiner la liste des billes
 * 
 * Comme ça si vous n'aimez pas mes composants awt vous pouvez les changer sans changer le reste de l'appli
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public interface VueBillard{
	public double largeurBillard();
	public double hauteurBillard();
	public void miseAJour();
	public void montrer();
	public void setBillardBilles(Vector<Bille> billes);
	public void enableResetButton();
	public boolean isDisabledResetButton();
	public void setBackgroundColor(Color c);
	public void setAnimationBilles(AnimationBilles animationBilles);
	public void switchButtons();
	public void checkNormalRadio();
	public void checkBillardRadio();
}
