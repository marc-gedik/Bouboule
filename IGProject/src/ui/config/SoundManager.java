package ui.config;

import ui.game.Sound;
import utils.AssetsManager;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundManager implements  LineListener {

    private AudioInputStream stream;
    private Line line;
    private Line.Info info;
    private BufferedInputStream audioSrc;
    public static Clip clip;

    private static int volume = AssetsManager.prefInt("Sound.Volume");

    public static int get() {
        return volume;
    }
    public static void set(int v){
        volume = v;
        AssetsManager.intPref("Sound.Volume", v);
    }

    public SoundManager() {

        info = new Line.Info(Clip.class);
        try {
            line = AudioSystem.getLine(info);
            clip = (Clip) line;
            clip.addLineListener(this);
            audioSrc = new BufferedInputStream(Sound.MainMenu);
            Sound.MainMenu = new AudioInputStream(audioSrc, Sound.MainMenu.getFormat(), Sound.MainMenu.getFrameLength());
            clip.open(Sound.MainMenu);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            play();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void play(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void end(){
        clip.stop();
    }

    @Override
    public void update(LineEvent lineEvent) {
        LineEvent.Type type = lineEvent.getType();
        if(type == LineEvent.Type.OPEN)
            System.out.println("Open sound file");
        else
        if(type == LineEvent.Type.CLOSE) {
            System.out.println("Close sound file");
            System.exit(0);
        }
        else
        if (type == LineEvent.Type.START) {
            System.out.println("Start sound file");
            play();
        }
        else
        if(type == LineEvent.Type.STOP) {
            System.out.println("Stop sound file");
            end();
        }
    }
}
