package ui.config;

import game.Conductor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameState;
import ui.GameStateManager;
import ui.Score;
import utils.AssetsManager;
import controler.WinListener;

public class Win extends GameState {

    private ActionListener listener;

    public Win(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        listener = new WinListener(gsm);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        position(gbc, 0, 0, 1, 1);
        this.add(buttonContainer(), gbc);
        addBackground(gbc, "img/texture3.png");

    }

    private Component buttonContainer() {
        JPanel containerButton = new JPanel();
        containerButton.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(7, 10, 10, 10);
        gbc.gridwidth = 2;

        JLabel title = new JLabel(AssetsManager.getString("Win.Victory"));
        title.setFont(ButtonStyle.DarkStyle.font());
        containerButton.add(title, gbc);

        System.out.println(Conductor.getScore());
        AssetsManager.addScore(new Score("Remplacer", Conductor.getScore()));
        JButton next = button("Win.Menu");

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridy = 1;
        gbc.gridx = 1;
        containerButton.add(next, gbc);


        next.requestFocusInWindow();
        containerButton.setPreferredSize(new Dimension(450, 300));
        containerButton.setMinimumSize(new Dimension(450, 300));
        containerButton.setSize(new Dimension(450, 300));
        containerButton.setOpaque(false);
        return containerButton;
    }

    private JButton button(String string) {
        JButton button = new DecoratedButton(AssetsManager.getString(string),
                ButtonStyle.WhiteStyle);
        button.addActionListener(listener);
        button.setActionCommand(string);
        return button;
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
    }
}
