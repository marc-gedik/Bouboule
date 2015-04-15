package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;
import controler.BackButtonListener;

public class ScoresMenu extends GameState {

	
public static String[] rank = new  String[10];

	
	public ScoresMenu(GameStateManager gsm) {
		super(gsm);
		init();
	}

	void init() {
		Background wallpaper = new Background(
				new ImageIcon("img/texture3.png"), Game.WIDTH_SCREEN,
				Game.HEIGHT_SCREEN);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		this.add(wallpaper, gbc);
	}


	JPanel buttonContainer(){
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);		
		JButton b = new DecoratedButton(Game.getConfig().getString("backButton"), GrayStyle.getInstance());
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		containerButton.add(b);

		return containerButton;

	}

	
	void tableStyle(JPanel containerText){
		
		
	}

	JPanel textContainer(){
		Font f = new Font("Helvetica",0, 14);
		Font f1 = new Font("Helvetica",Font.BOLD, 16);

	
		Border bottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
		
		JPanel containerText  = new  JPanel();
		containerText.setBackground(Color.WHITE);		
		containerText.setLayout(new GridLayout(11,3,0,4));

		JLabel row1 = new JLabel("NOM");
		JLabel row2 = new JLabel("SCORE");
		JLabel row3 = new JLabel("RANK");

		row1.setBorder(bottom);
		row2.setBorder(bottom);
		row3.setBorder(bottom);

		
		//row1.setOpaque(false);
		JPanel p = new JPanel();
		//p.setBorder());
		;
		//p.setBackground(Color.BLUE);
		row1.setFont(f1);
		row2.setFont(f1);
		row3.setFont(f1);

		containerText.add(row1);
		containerText.add(row2);
row3.setHorizontalTextPosition(SwingConstants.CENTER);

		containerText.add(row3);


		for (int i = 0; i < 10; i++) {
			containerText.add(new JLabel(""+i));
			containerText.add(new JLabel("MarcLeNul"+i));
			containerText.add(new JLabel("12222232"+i));

		}
		return containerText;

	}



	JPanel myContainer(){
		JPanel myContainer = new JPanel();
		myContainer.setBorder( new EmptyBorder(10, 10, 10, 10));
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
