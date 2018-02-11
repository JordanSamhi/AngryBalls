package projet.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * 
 * Op�rations utiles sur les billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class OutilsBille
{
	/**
	 * @param billes est la liste de TOUTES les billes en mouvement
	 * @param cetteBille est l'une d'entre elles.
	 * @return la liste des autres billes que cetteBille, c'est-�-dire la liste de toutes les billes sauf cetteBille 
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
	 * @param cetteBille : une bille particuli�re
	 * @param billes : une liste de billes, cette liste peut contenir cettebille
	 *
	 * gestion de l'�ventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
	 * 
	 * @return null si pas de collision
	 * 			vecteur vitesse correspondant � la plus grande vitesse des deux billes en collision
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
	 * @param cetteBille : une bille particuli�re
	 * @param billes : une liste de billes, cette liste peut contenir cettebille
	 * 
	 * On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
	 * 
	 * t�che : calcule a, le vecteur acc�l�ration subi par cetteBille r�sultant de l'attraction par les autres billes de la liste.
	 * 
	 * @return a : le vecteur acc�l�ration r�sultant
	 * 
	 * */
	
	public static Vecteur gestionAcc�l�rationNewton(Bille cetteBille, Vector<Bille> billes){
		Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

		//-------------- � pr�sent on r�cup�re les masses et les positions des autres billes ------------------
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

		//------------------ � pr�sent on calcule le champ de gravit� exerc� par les autres billes sur cette bille ------------------

		return  MecaniquePoint.champGravit�Global( cetteBille.getPosition(),  masses, C);
	}
}
