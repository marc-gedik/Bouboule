package controler;

import ui.Game;
import ui.config.KeysMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static ui.config.KeysMenu.forUp;

public class FieldListener implements ActionListener, KeyListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("Field selected");
		JButton tmp = (JButton) actionEvent.getSource();
		tmp.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		System.out.println("Key Typed");
		System.out.println();

		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_UP:
			((JButton)keyEvent.getSource()).setText(Game.getConfig().getString("\u2191"));
			break;
		case KeyEvent.VK_DOWN:
			((JButton)keyEvent.getSource()).setText(Game.getConfig().getString("\u2193"));
			break;
		case KeyEvent.VK_RIGHT:
			((JButton)keyEvent.getSource()).setText(Game.getConfig().getString("\u2192"));
			break;
		case KeyEvent.VK_LEFT:
			((JButton)keyEvent.getSource()).setText(Game.getConfig().getString("\u2190"));
			break;
		default:
			((JButton) keyEvent.getSource()).setText(String.valueOf(keyEvent.getKeyChar()).toUpperCase());
		}

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		int keycode = keyEvent.getKeyCode();

		switch(((JButton)keyEvent.getSource()).getActionCommand()){
			case "Up":
				KeysOption.setUp(keycode);
				break;
			case "Down":
				KeysOption.setDown(keycode);
				break;
			case "Left":
				KeysOption.setLeft(keycode);
				break;
			case "Right":
				KeysOption.setRight(keycode);
				break;
			case "Action":
				KeysOption.setAction(keycode);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}
}
