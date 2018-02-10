package sounds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public abstract class Sound {

	protected URL url;
	protected AudioClip sound;
	
	protected Sound(String file) {
		url = this.getClass().getClassLoader().getResource(file);
		sound = Applet.newAudioClip(url);
	}

	public void playSound(boolean collision){
		if(collision)
			sound.play();
	}
}
