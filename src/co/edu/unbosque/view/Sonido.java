package co.edu.unbosque.view;


import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sonido() {
		soundURL[0] = getClass().getResource("/Musica/ChillMusic.wav");

	}
	public void setFile(int i) {
		try {
			AudioInputStream mus = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(mus);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void play() {
		
		clip.start();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	
	

}
