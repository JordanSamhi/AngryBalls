package sounds;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.scene.media.AudioClip;
import mesmaths.geometrie.base.Vecteur;

public class Sound{
	private static Sound instance = null;
	private boolean mute;
	private final String soundBilleBordFile = "/sounds/billeBord.wav";
	private final String soundCollisionBilleFile = "/sounds/collisionBille.wav";
	private AudioClip soundBilleBord, soundCollisionBille;

	private Sound() {
		try {
			this.soundBilleBord = new AudioClip(this.getClass().getResource(soundBilleBordFile).toURI().toURL().toString());
			this.soundCollisionBille = new AudioClip(this.getClass().getResource(soundCollisionBilleFile).toURI().toURL().toString());
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
		this.playSound(this.soundBilleBord, collision, (float) (intensite.norme()), side);
	}

	public void playSoundBilleBille(Vecteur intensite, double side){
		if(intensite != null)
			this.playSound(this.soundCollisionBille, true, (float) (intensite.norme()), side);
	}

	private void playSound(AudioClip clip, boolean collision, float intensiteVolume, double side) {
		if(collision && !this.mute){
			clip.play(Math.min(1.0, intensiteVolume), side, 1, 0, 0);
		}
	}
	
	public void muteUnMute() {
		this.mute = !this.mute;
	}
}
