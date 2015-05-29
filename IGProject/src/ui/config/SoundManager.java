package ui.config;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import utils.AssetsManager;

public class SoundManager {

	private static int volume = AssetsManager.prefInt("Sound.Volume");
	private FloatControl fc;
	private Clip clip;

	public static int get() {
		return volume;
	}

	public SoundManager() {
	}

	private AudioInputStream get(File file) {
		try {
			return AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void playMusic(File mainMenu) {
		try {
			if (clip != null)
				clip.stop();
			clip = AudioSystem.getClip();
			clip.open(get(mainMenu));
			fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			fc.setValue(volume);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}

	public void playSound(String src) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(get(AssetsManager.getMusic(src)));
			clip.setFramePosition(0);
			FloatControl fc = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);
			fc.setValue(volume);
			clip.start();
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}

	public void setVolume(int v) {
		fc.setValue(v);
		AssetsManager.intPref("Sound.Volume", v);
	}
}
