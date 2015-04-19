package controler;



import ui.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldListener implements ActionListener, KeyListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Field selected");
        JButton tmp = (JButton)actionEvent.getSource();
        tmp.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("Key Typed");
        JButton tmp = (JButton)keyEvent.getSource();
        System.out.println();

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                tmp.setText(Game.getConfig().getString("Keys.Up"));
                break;
            case KeyEvent.VK_DOWN:
                tmp.setText(Game.getConfig().getString("Keys.Down"));
                break;
            case KeyEvent.VK_RIGHT:
                tmp.setText(Game.getConfig().getString("Keys.Right"));
                break;
            case KeyEvent.VK_LEFT:
                tmp.setText(Game.getConfig().getString("Keys.Left"));
                break;
            default:
                tmp.setText(String.valueOf(keyEvent.getKeyChar()).toUpperCase());
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
