package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import ui.Game;
import utils.AssetsManager;

public class FieldListener implements ActionListener, KeyListener {

	private JButton tmp;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("Field selected");
		tmp = (JButton) actionEvent.getSource();
		tmp.removeKeyListener(this);
		tmp.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		int keycode = keyEvent.getKeyCode();
		tmp.setText(KeysOption.toString(keycode));

		String s = tmp.getActionCommand();
		if (s.equals("Keys.Up"))
			KeysOption.Up.set(keycode);
		else if (s.equals("Keys.Down"))
			KeysOption.Down.set(keycode);
		else if (s.equals("Keys.Left"))
			KeysOption.Left.set(keycode);
		else if (s.equals("Keys.Right"))
			KeysOption.Right.set(keycode);
		else if (s.equals("Keys.Action"))
			KeysOption.Action.set(keycode);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}
}
