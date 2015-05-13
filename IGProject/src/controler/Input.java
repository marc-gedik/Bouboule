package controler;

import java.awt.event.KeyEvent;

public class Input {
	private static final int SIZE = KeyEvent.KEY_LAST;
	public static boolean[] keys;

	static {
		keys = new boolean[SIZE];
	}

	public static boolean up() {
		return keys[KeysOption.Up.get()];
	}

	public static boolean down() {
		return keys[KeysOption.Down.get()];
	}

	public static boolean left() {
		return keys[KeysOption.Left.get()];
	}

	public static boolean right() {
		return keys[KeysOption.Right.get()];
	}

	public static boolean enter() {
		return keys[KeyEvent.VK_ENTER];
	}

	public static void update() {

	}

}
