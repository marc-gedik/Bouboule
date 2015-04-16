package controler;

import java.awt.event.KeyEvent;

public class Input {
	private static final int SIZE = KeyEvent.KEY_LAST;
	public static boolean[] keys;

	static {
		keys = new boolean[SIZE];
	}

	public static boolean up() {
		return keys[KeysOption.getUp()];
	}

	public static boolean down() {
		return keys[KeysOption.getDown()];
	}
	
	public static boolean left() {
		return keys[KeysOption.getLeft()];
	}

	public static boolean right() {
		return keys[KeysOption.getRight()];
	}

	public static boolean enter() {
		return keys[KeyEvent.VK_ENTER];
	}



	public static void update() {
		
	}

}
