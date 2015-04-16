package ui.config;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ImageButton extends JButton{

	
	
	
	public ImageButton(String icon, String over, String name) {
		super(new ImageIcon(icon));
		setText(name);
		Font f = new Font("Helvetica", 0, 22);
		setForeground(Color.GRAY);
		setFont(f);
		
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setRolloverIcon(new ImageIcon( over));
		setActionCommand(name);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
}
