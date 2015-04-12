package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import controler.BackButtonListener;
import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class InstructionsMenu extends GameState{

	public InstructionsMenu(GameStateManager gsm) {
		super(gsm);
		init();
	}


	void init(){
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
				Game.WIDTH_SCREEN, Game.HEIGHT_SCREEN);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		this.add(wallpaper, gbc);


	}	


	
	JPanel buttonContainer(){
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);		
		JButton b = new DecoratedButton("backButton",2);
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);
		
		return tmp;
		
	}

	
	JPanel textContainer(){
		JPanel 	containerText = new JPanel();
		
		containerText.setLayout(new BorderLayout());

		String title1 = Game.getConfig().getString("Instructions.title1");
		String text1 = Game.getConfig().getString("Instructions.text1");
		String title2 = Game.getConfig().getString("Instructions.title2");
		String text2 = Game.getConfig().getString("Instructions.text2");

		Insets m = new Insets(5,5,0,0);
		JTextPane jtp1 = printer(title1, text1);
		jtp1.setMargin(m);
		JTextPane jtp2 = printer(title2, text2);
		jtp2.setMargin(m);
		containerText.add(jtp1, BorderLayout.NORTH);
		containerText.add(jtp2, BorderLayout.CENTER);
		return containerText;
	}
	
	JPanel myContainer(){
		JPanel myContainer = new JPanel();
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);		
		myContainer.setPreferredSize(new Dimension(500, 300));
		myContainer.setMinimumSize(new Dimension(500, 300));
		myContainer.setSize(new Dimension(500, 300));
		myContainer.setLayout(new BorderLayout());
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);
		myContainer.add(textContainer(), BorderLayout.NORTH);	

	return myContainer;	
	}





	public static JTextPane printer(String title, String text){

		JTextPane jtp = new JTextPane();
		jtp.setEditable(false);

		SimpleAttributeSet titleStyle = new SimpleAttributeSet();
		StyleConstants.setForeground(titleStyle, Color.BLACK);
		StyleConstants.setFontFamily( titleStyle, "Helvetica");
		StyleConstants.setFontSize(titleStyle, 18);
		StyleConstants.setBold(titleStyle, true);

		SimpleAttributeSet textStyle = new SimpleAttributeSet();
		StyleConstants.setFontFamily( textStyle, "Helvetica");
		StyleConstants.setFontSize(textStyle, 14);
		StyleConstants.setForeground(textStyle, Color.GRAY);

		SimpleAttributeSet indent = new SimpleAttributeSet();
		StyleConstants.setLeftIndent(indent, 10);
		MutableAttributeSet  space = new SimpleAttributeSet();
		StyleConstants.setLineSpacing(space, 0.5f);


		try {
			StyledDocument doc = jtp.getStyledDocument();
			doc.insertString(doc.getLength(), title+"\n", titleStyle);
			int end_title=doc.getLength();
			
			doc.insertString(doc.getLength(), text, textStyle);
			int end_text=doc.getLength();
			
			doc.setParagraphAttributes(0, end_title, space, false);
			doc.setParagraphAttributes(end_title, end_text, space, false);
			doc.setParagraphAttributes(end_title, end_text, indent, false);
			doc.setParagraphAttributes(end_text, doc.getLength(), indent, false);
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		return jtp;


	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
