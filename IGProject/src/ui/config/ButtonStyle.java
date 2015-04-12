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
		super(new Font("Helvetica", Font.BOLD, 16), Color.BLACK, Color.WHITE,
				new Color(240, 240, 240));
	}
}

class GrayStyle extends ButtonStyle {
	private static ButtonStyle INSTANCE = new GrayStyle();

	public static ButtonStyle getInstance() {
		return INSTANCE;
	}

	private GrayStyle() {
		super(new Font("Helvetica", Font.BOLD, 18), Color.BLACK, Color.GRAY,
				new Color(240, 240, 240));
	}

}