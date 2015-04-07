package ui.config;

import ui.Background;
import ui.GameState;
import ui.GameStateManager;
import ui.game.MainMenuListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;


public class MainMenu extends GameState implements ButtonModel {

	MainMenuListener action;
	public MainMenu(GameStateManager gsm) {
		super(gsm);
		this.setPreferredSize(new Dimension(600,400));	
		init();		
	}


	void init(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),2048,2048);
		action = new MainMenuListener();
		JPanel myContainer;
		myContainer = buttonContainer();		
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer, gbc);
		this.add(wallpaper, gbc);
	}	



	JPanel buttonContainer(){
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4,0,25,25));
		JButton play = customizeButton("Jouer");		
		JButton	load = customizeButton("Charger une partie");
		JButton	instruction = customizeButton("Instructions");
		JButton	score = customizeButton("Score");
		
		play.addActionListener(action);
		load.addActionListener(action);
		instruction.addActionListener(action);
		score.addActionListener(action);

		containerButton.add(play);
		containerButton.add(load);
		containerButton.add(instruction);
		containerButton.add(score);
		containerButton.setPreferredSize(new Dimension(350, 260));
		containerButton.setMinimumSize(new Dimension(350, 260));
		containerButton.setSize(new Dimension(350, 260));
		containerButton.setOpaque(false);
		return containerButton;

	}


	JButton customizeButton(String name){
		JButton btn = new JButton(name);
		btn.setFont(new Font("Helvetica", Font.BOLD, 18));       
		btn.setBackground(Color.white);
		btn.setForeground(Color.gray);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		return btn;
	}

	public static void position(GridBagConstraints gbc, int x, int y, int a,
			int b) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = a;
		gbc.gridwidth = b;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // fin de la ligne
	}


	@Override
	public Object[] getSelectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isArmed() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isRollover() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setArmed(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPressed(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setRollover(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setMnemonic(int key) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getMnemonic() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setActionCommand(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getActionCommand() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setGroup(ButtonGroup group) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addItemListener(ItemListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeItemListener(ItemListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
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
