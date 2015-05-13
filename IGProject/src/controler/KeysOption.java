package controler;

import java.awt.event.KeyEvent;

import utils.AssetsManager;


public enum KeysOption {

	Up, Down, Left, Right, Action;
	
	private int code ;
	{
		code = AssetsManager.prefInt(this.toString());
	}
	
	public int get() {
		return code;
	}
	public void set(int code){
		this.code = code;
		AssetsManager.intPref(toString(), code);
	}
	
	@Override
	public String toString() {
		return "Keys." + super.toString();
	}
	
	public static String toString(int keyCode){
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return "\u2191";
		case KeyEvent.VK_DOWN:
			return "\u2193";
		case KeyEvent.VK_LEFT:
			return "\u2190";
		case KeyEvent.VK_RIGHT:
			return "\u2192";
		default:
			return KeyEvent.getKeyText(keyCode);
		}
	}

}
