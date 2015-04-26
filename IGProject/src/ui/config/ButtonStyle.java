package ui.config;

import java.awt.Color;
import java.awt.Font;

abstract class ButtonStyle {
	private Font font;
	private Color fg, bg, hover;

	public ButtonStyle(Font font, Color fg, Color bg, Color hover) {
		this.font = font;
		this.fg = fg;
		this.bg = bg;
		this.hover = hover;
	}

	public Font font() {
		return font;
	}

	public Color foreground() {
		return fg;
	}

	public Color background() {
		return bg;
	}

	public Color onHover() {
		return hover;
	}

}

class WhiteStyle extends ButtonStyle {
	private static ButtonStyle INSTANCE = new WhiteStyle();

	public static ButtonStyle getInstance() {
		return INSTANCE;
	}

	private WhiteStyle() {
		super(new Font("Helvetica", Font.BOLD, 16), Color.GRAY, Color.WHITE,
				new Color(240, 240, 240));
	}
}

class BlueStyle extends ButtonStyle {
	private static ButtonStyle INSTANCE = new BlueStyle();

	public static ButtonStyle getInstance() {
		return INSTANCE;
	}

	private BlueStyle() {
		super(new Font("Helvetica", 0, 16), Color.BLACK, new Color(220, 240,
				240), new Color(240, 240, 240));
	}
}

class GrayStyle extends ButtonStyle {
	private static ButtonStyle INSTANCE = new GrayStyle();

	public static ButtonStyle getInstance() {
		return INSTANCE;
	}

	private GrayStyle() {
		super(new Font("Helvetica", Font.BOLD, 16), Color.WHITE, new Color(117,
				117, 117), new Color(160, 160, 160));
	}

}