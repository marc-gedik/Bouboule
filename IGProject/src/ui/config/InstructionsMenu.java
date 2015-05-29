package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import controler.BackButtonListener;

public class InstructionsMenu extends GameState {

	public InstructionsMenu(GameStateManager gsm) {
		super(gsm);
	}
	@Override
	public void init() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		addBackground(gbc, "img/texture3.png");
	}

	JPanel buttonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		 JButton b = new DecoratedButton(AssetsManager.getString("backButton"),
				ButtonStyle.GrayStyle);
		BackButtonListener bl = new BackButtonListener(gsm);
		b.requestFocusInWindow();
		b.addActionListener(bl);
		tmp.add(b);

		return tmp;

	}

	JPanel textContainer() {
		JPanel containerText = new JPanel();
		
		containerText.setLayout(new BorderLayout());
		String title1 = AssetsManager.getString("Instructions.title1");
		String text1 = AssetsManager.getString("Instructions.text1");
		String title2 = AssetsManager.getString("Instructions.title2");
		String text2 = AssetsManager.getString("Instructions.text2");

		JTextPane jtp1 = printer(title1, text1);
		jtp1.setFocusable(false);
		JTextPane jtp2 = printer(title2, text2);
		jtp1.setPreferredSize((new Dimension(600, 180)));
		jtp2.setPreferredSize((new Dimension(600, 120)));
		jtp2.setFocusable(false);
		containerText.add(jtp1, BorderLayout.NORTH);
		containerText.add(jtp2, BorderLayout.SOUTH);

		return containerText;
	}

	JPanel myContainer() {
		JPanel myContainer = new JPanel();
		myContainer.setBorder(new EmptyBorder(15, 15, 15, 15));
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);
		myContainer.setPreferredSize(new Dimension(600, 400));
		myContainer.setMinimumSize(new Dimension(600, 400));
		myContainer.setSize(new Dimension(600, 400));
		myContainer.setLayout(new BorderLayout());
		myContainer.add(textContainer(), BorderLayout.NORTH);
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);

		return myContainer;
	}

	public static JTextPane printer(String title, String text) {

		JTextPane jtp = new JTextPane();
		jtp.setEditable(false);

		SimpleAttributeSet titleStyle = new SimpleAttributeSet();
		StyleConstants.setForeground(titleStyle, Color.BLACK);
		StyleConstants.setFontFamily(titleStyle, "Helvetica");
		StyleConstants.setFontSize(titleStyle, 18);
		StyleConstants.setBold(titleStyle, true);

		SimpleAttributeSet textStyle = new SimpleAttributeSet();
		StyleConstants.setFontFamily(textStyle, "Helvetica");
		StyleConstants.setFontSize(textStyle, 14);
		StyleConstants.setForeground(textStyle, Color.GRAY);

		SimpleAttributeSet indent = new SimpleAttributeSet();
		StyleConstants.setLeftIndent(indent, 10);
		MutableAttributeSet space = new SimpleAttributeSet();
		StyleConstants.setLineSpacing(space, 0.5f);

		try {
			StyledDocument doc = jtp.getStyledDocument();
			doc.insertString(doc.getLength(), title + "\n", titleStyle);
			int end_title = doc.getLength();

			doc.insertString(doc.getLength(), text, textStyle);
			int end_text = doc.getLength();

			doc.setParagraphAttributes(0, end_title, space, false);
			doc.setParagraphAttributes(end_title, end_text, space, false);
			doc.setParagraphAttributes(end_title, end_text, indent, false);
			doc.setParagraphAttributes(end_text, doc.getLength(), indent, false);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return jtp;

	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

}
