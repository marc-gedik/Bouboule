package ui.config;

import java.awt.Color;
import java.awt.Font;

enum ButtonStyle {
	WhiteStyle(new Font("Helvetica", Font.BOLD, 16), Color.GRAY, Color.WHITE, new Color(240, 240, 240)), 
	BlueStyle(new Font("Helvetica", 0, 16),	Color.BLACK, new Color(220, 240, 240), new Color(240, 240, 240)),
	GrayStyle(new Font("Helvetica", Font.BOLD, 16), Color.WHITE, new Color(117,	117, 117), new Color(160, 160, 160)),
	DarkStyle(new Font("Helvetica", Font.BOLD, 24), Color.BLACK, Color.WHITE, new Color(240, 240, 240));;

	public final Font font;
	public final Color fg, bg, hover;

	ButtonStyle(Font font, Color fg, Color bg, Color hover) {
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