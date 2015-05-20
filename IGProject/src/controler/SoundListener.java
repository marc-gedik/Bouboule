package controler;


import ui.Game;
import ui.config.SoundMenu;
import ui.config.SoundManager;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SoundListener implements ChangeListener {


    @Override
    public void stateChanged(ChangeEvent changeEvent) {

        JSlider slider = (JSlider) changeEvent.getSource();
        if(!slider.getValueIsAdjusting()){
            int v = slider.getValue();
            System.out.println(v);
            if(SoundManager.get()!=0) {
                if (v == 0)
                    Game.soundManager.end();
                else {
                    Game.soundManager.setGain(v);
                }
            }
            else{
                if (v != 0)
                    Game.soundManager.play();
            }
            SoundManager.set(v);
        }
    }
}
