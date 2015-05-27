package ui.config;


import controler.GameOverListener;
import controler.LevelTransitionListener;
import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelTransition extends GameState {

    private ActionListener listener;

    public LevelTransition(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        listener = new LevelTransitionListener(gsm);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        position(gbc, 0, 0, 1, 1);
        this.add(buttonContainer(), gbc);
        addBackground(gbc, "img/texture3.png");

    }

    private Component buttonContainer() {
        JPanel containerButton = new JPanel();
        containerButton.setLayout(new GridLayout(4, 0 , 50 , 50));

        JLabel title = new JLabel(AssetsManager.getString("Win.Next"));
        title.setFont(ButtonStyle.DarkStyle.font());
        containerButton.add(title, BorderLayout.CENTER);

        JButton next = button("Win.Move");
        JButton save = button("Win.Save");
        JButton menu = button("Win.Menu");

        containerButton.add(next);

        containerButton.add(save);

        containerButton.add(menu);

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
        button.setSize(new Dimension(450, 100));
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
