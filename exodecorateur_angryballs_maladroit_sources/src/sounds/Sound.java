package sounds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {

	private URL urlSonBilleBord, urlSonBilleBille;
	private AudioClip soundBilleBord, soundBilleBille;
	private boolean mute;
	private static Sound instance = null;
	
	private Sound() {
		urlSonBilleBord = this.getClass().getClassLoader().getResource("sounds/billeBord.wav");
		urlSonBilleBille = this.getClass().getClassLoader().getResource("sounds/collisionBille.wav");
		soundBilleBord = Applet.newAudioClip(urlSonBilleBord);
		soundBilleBille = Applet.newAudioClip(urlSonBilleBille);
		this.mute = false;
	}
	
	public static Sound getInstance() {
		if(instance == null)
			instance = new Sound();
		return instance;
	}

	public void playSoundBilleBord(boolean collision){
		this.playSound(soundBilleBord, collision);
	}
	
	public void playSoundBilleBille(boolean collision){
		this.playSound(soundBilleBille, collision);
	}
	
	private void playSound(AudioClip sound, boolean collision) {
		if(collision && !mute) {
			sound.play();
		}
	}
	
	public void muteUnMute() {
		this.mute = !this.mute;
	}
}
