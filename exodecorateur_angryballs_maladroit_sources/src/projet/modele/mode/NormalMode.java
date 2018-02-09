package projet.modele.mode;

import java.awt.Color;

import mesmaths.geometrie.base.Vecteur;
import projet.modele.Bille;
import projet.modele.BilleNue;
import projet.modele.decorateurs.AttractionUniverselle;
import projet.modele.decorateurs.Frottement;
import projet.modele.decorateurs.MouvementRectiligneUniforme;
import projet.modele.decorateurs.PasseATravers;
import projet.modele.decorateurs.Pesanteur;
import projet.modele.decorateurs.RebondBord;
import projet.modele.decorateurs.RebondBordBloque;

public class NormalMode extends Mode{
	public NormalMode() {
		super();
	}

	@Override
	public void preparerBilles() {
		Bille b1, b2, b3, b4, b5;
		
		b1 = new BilleNue(Vecteur.créationAléatoire(0, 0, this.xMax, this.yMax), this.rayon, Color.red);
		b1 = new MouvementRectiligneUniforme(b1, Vecteur.créationAléatoire(-this.vMax, -this.vMax, this.vMax, this.vMax));
		b1 = new RebondBord(b1);
		
		b2 = new BilleNue(Vecteur.créationAléatoire(0, 0, this.xMax, this.yMax), this.rayon, Color.blue);
		b2 = new MouvementRectiligneUniforme(b2, Vecteur.créationAléatoire(-this.vMax, -this.vMax, this.vMax, this.vMax));
		b2 = new PasseATravers(b2);
		
		b3 = new BilleNue(Vecteur.créationAléatoire(0, 0, this.xMax, this.yMax), this.rayon, Color.green);
		b3 = new AttractionUniverselle(b3);
		b3 = new Frottement(b3);
		b3 = new RebondBord(b3);
		
		b4 = new BilleNue(Vecteur.créationAléatoire(0, 0, this.xMax, this.yMax), this.rayon, Color.yellow);
		b4 = new Pesanteur(b4, this.pesanteur);
		b4 = new Frottement(b4);
		b4 = new RebondBord(b4);
		
		b5 = new BilleNue(Vecteur.créationAléatoire(0, 0, this.xMax, this.xMax), rayon, Color.black);
		b5 = new MouvementRectiligneUniforme(b5, Vecteur.créationAléatoire(-this.vMax, -this.vMax, this.vMax, this.vMax));
		b5 = new RebondBordBloque(b5);
		b5 = new AttractionUniverselle(b5);
		
		this.billes.add(b1);
		this.billes.add(b2);
		this.billes.add(b3);
		this.billes.add(b4);
		this.billes.add(b5);
	}

	@Override
	public Color getColorTable() {
		return Color.WHITE;
	}
	
}
