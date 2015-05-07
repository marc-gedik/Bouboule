package ui.config;

import ui.game.Sound;

import javax.sound.sampled.*;
import java.io.IOException;

public class SoundThread extends Thread {

    private AudioInputStream stream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip clip;

    public SoundThread() {}

    public void run() {

        stream = Sound.MainMenu;

        format = stream.getFormat();
        info = new DataLine.Info(Clip.class, format);
        try {
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}