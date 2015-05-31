package controler;

import game.Conductor;
import game.Levels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class LevelTransitionListener implements ActionListener {

    private GameStateManager gsm;

    public LevelTransitionListener(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Win.Move")){
            Levels.next();
            gsm.setState(GameStateManager.GAME);
        }
        else if (e.getActionCommand().equals("Win.Menu")){
            gsm.popState();
            Conductor.reset();
        }

    }
}
