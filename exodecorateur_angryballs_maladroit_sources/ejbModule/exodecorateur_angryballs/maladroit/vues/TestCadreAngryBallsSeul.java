package exodecorateur_angryballs.maladroit.vues;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.BilleProf;


public class TestCadreAngryBallsSeul
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Vector<BilleProf> billes = new Vector<BilleProf>();
		CadreAngryBalls cadre =new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
		cadre.montrer();
	}

}
