package sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import mesmaths.geometrie.base.Vecteur;

public class Sound {

	private static Sound instance = null;
	private boolean mute;
	private File sonBilleBord, sonBilleBille;

	private Sound() {
		this.sonBilleBord = new File("bin/sounds/billeBord.wav");
		this.sonBilleBille = new File("bin/sounds/collisionBille.wav");
		this.mute = false;
	}

	public static Sound getInstance() {
		if(instance == null)
			instance = new Sound();
		return instance;
	}

	public void playSoundBilleBord(boolean collision, Vecteur intensite){
		this.playSound(this.sonBilleBord, collision, (float) (intensite.norme()));
	}

	public void playSoundBilleBille(Vecteur intensite){
		if(intensite != null)
			this.playSound(this.sonBilleBille, true, (float) (intensite.norme()));
	}

	private void playSound(File file, boolean collision, float intensiteVolume) {
		if(collision && !this.mute){
			AudioInputStream audioInputStream = null;
			Clip clip = null;
			FloatControl control = null;
			float range, volume;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			} catch (LineUnavailableException | IOException e){
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e){
				e.printStackTrace();
			}
			range = control.getMaximum() - control.getMinimum();
			volume = (range * Math.min(1.0f, Math.max(0.4f, intensiteVolume))) + control.getMinimum();
			control.setValue(volume);
			clip.start();
		}
	}
	
	public void muteUnMute() {
		this.mute = !this.mute;
	}
}
