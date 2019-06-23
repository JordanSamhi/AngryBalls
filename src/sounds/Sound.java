package sounds;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.AudioClip;
import mesmaths.geometrie.base.Vecteur;

public class Sound{
	private static Sound instance = null;
	private boolean mute;

	private final String soundBilleBordFile = "/sounds/billeBord.wav";
	private final String soundCollisionBilleFile = "/sounds/collisionBille.wav";

	/**
	 * list sounds car délai très court possible entre deux chocs
	 * cela évite les latences, on prendra le premier de la liste
	 * qui n'est pas occupé
	 */
	private List<AudioClip> clipsBordBille = new ArrayList<AudioClip>();
	private List<AudioClip> clipsBilleBille = new ArrayList<AudioClip>();

	private static final int maxSounds = 5;

	private Sound() {
		try {
			for(int i = 0 ; i < Sound.maxSounds ; i++){
				clipsBordBille.add(new AudioClip(this.getClass().getResource(soundBilleBordFile).toURI().toURL().toString()));
				clipsBilleBille.add(new AudioClip(this.getClass().getResource(soundCollisionBilleFile).toURI().toURL().toString()));
			}
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		this.mute = false;
	}

	public static Sound getInstance() {
		if(instance == null)
			instance = new Sound();
		return instance;
	}

	public void playSoundBilleBord(boolean collision, Vecteur intensite, double side){
		this.playSound(this.clipsBordBille, collision, (float) (intensite.norme()), side);
	}

	public void playSoundBilleBille(Vecteur intensite, double side){
		if(intensite != null)
			this.playSound(this.clipsBilleBille, true, (float) (intensite.norme()), side);
	}

	private void playSound(List<AudioClip> clips, boolean collision, float intensiteVolume, double side) {
		if(collision && !this.mute)
			for(AudioClip audioClip : clips)
				if(!audioClip.isPlaying())
					audioClip.play(Math.min(1.0, intensiteVolume), side, 1, 0, 0);
	}

	public void muteUnMute() {
		this.mute = !this.mute;
	}
}
