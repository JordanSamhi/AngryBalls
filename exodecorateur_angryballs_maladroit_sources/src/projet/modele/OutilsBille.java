package projet.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * 
 * Opérations utiles sur les billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class OutilsBille
{
	/**
	 * @param billes est la liste de TOUTES les billes en mouvement
	 * @param cetteBille est l'une d'entre elles.
	 * @return la liste des autres billes que cetteBille, c'est-à-dire la liste de toutes les billes sauf cetteBille 
	 * 
	 * */
	public static Vector<Bille> autresBilles(Bille cetteBille, Vector<Bille> billes){
		Vector<Bille> autresBilles = new Vector<Bille>();

		for(Bille bille : billes) {
			if(bille.getClef() != cetteBille.getClef())
				autresBilles.add(bille);
		}
		return autresBilles;
	}


	/**
	 * @param cetteBille : une bille particulière
	 * @param billes : une liste de billes, cette liste peut contenir cettebille
	 *
	 * gestion de l'éventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
	 * 
	 * @return null si pas de collision
	 * 			vecteur vitesse correspondant à la plus grande vitesse des deux billes en collision
	 * */
	
	public static Vecteur gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> billes){
		Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);
		for(Bille bille : autresBilles) {
			if(Collisions.CollisionBilleBille(cetteBille.getPosition(), cetteBille.getRayon(), cetteBille.getVitesse(), cetteBille.masse(),
					bille.getPosition(), bille.getRayon(), bille.getVitesse(), bille.masse())){
				if(cetteBille.getVitesse().norme() > bille.getVitesse().norme())
					return cetteBille.getVitesse();
				return bille.getVitesse();
			}
				
		}
		return null;
	}


	/**
	 * @param cetteBille : une bille particulière
	 * @param billes : une liste de billes, cette liste peut contenir cettebille
	 * 
	 * On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
	 * 
	 * tâche : calcule a, le vecteur accélération subi par cetteBille résultant de l'attraction par les autres billes de la liste.
	 * 
	 * @return a : le vecteur accélération résultant
	 * 
	 * */
	
	public static Vecteur gestionAccélérationNewton(Bille cetteBille, Vector<Bille> billes){
		Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

		//-------------- à présent on récupère les masses et les positions des autres billes ------------------
		int i;
		Bille billeCourante;

		int d = autresBilles.size();

		double masses [] = new double[d];   // les masses des autres billes
		Vecteur C [] = new Vecteur[d];      // les positions des autres billes

		for ( i = 0; i < d; ++i)
		{
			billeCourante = autresBilles.get(i);
			masses[i] = billeCourante.masse();
			C[i] = billeCourante.getPosition();
		}

		//------------------ à présent on calcule le champ de gravité exercé par les autres billes sur cette bille ------------------

		return  MecaniquePoint.champGravitéGlobal( cetteBille.getPosition(),  masses, C);
	}
}
