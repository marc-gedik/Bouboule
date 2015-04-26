package controler;

import java.awt.event.KeyEvent;

public class KeysOption {

	private static int up = KeyEvent.VK_UP, down = KeyEvent.VK_DOWN,
			left = KeyEvent.VK_LEFT, right = KeyEvent.VK_RIGHT;

	public static final int getUp() {
		return up;
	}

	public static void setUp(int up) {
		KeysOption.up = up;
	}

	public static final int getDown() {
		return down;
	}

	public static void setDown(int down) {
		KeysOption.down = down;
	}

	public static int getLeft() {
		return left;
	}

	public static void setLeft(int left) {
		KeysOption.left = left;
	}

	public static int getRight() {
		return right;
	}

	public static void setRight(int right) {
		KeysOption.right = right;
	}

}
