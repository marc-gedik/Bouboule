package ui.config;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;

import javax.swing.*;
import java.awt.*;

public class SoundMenu extends GameState{

    public SoundMenu(GameStateManager gsm){
        super(gsm);
        init();
    }

    void init(){
        Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
                Game.WIDTH_SCREEN, Game.HEIGHT_SCREEN);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        position(gbc, 0, 0, 1, 1);
        this.add(myContainer(), gbc);

        this.add(wallpaper, gbc);
    }

    JPanel slideContainer(){
        JPanel tmp = new JPanel();
        tmp.setBackground(Color.WHITE);
        tmp.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        position(gbc, 0, 0, 1, 1);

        JLabel bgm = new JLabel(Game.getConfig().getString("Sound.Bgm"));
        JLabel volume = new JLabel(Game.getConfig().getString("Sound.Music"));

        JSlider forBgm = new JSlider(0,10);
        JSlider forVolume = new JSlider(0,10);

        tmp.add(bgm);
        tmp.add(forBgm);
        gbc.gridy = 10;
        tmp.add(volume);
        tmp.add(forVolume);

        return tmp;
    }

    JPanel myContainer(){
        JPanel myContainer = new JPanel();
        myContainer.setLayout(new BorderLayout());
        myContainer.setBackground(Color.WHITE);
        myContainer.setPreferredSize(new Dimension(500, 400));
        myContainer.setMinimumSize(new Dimension(500, 400));
        myContainer.setSize(new Dimension(500, 300));
        myContainer.setLayout(new BorderLayout());
        myContainer.add(slideContainer());
        return myContainer;
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
