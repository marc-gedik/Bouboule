package controler;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import ui.GameStateManager;
import ui.config.DecoratedButton;
import ui.config.MainMenu;

public class MainMenuFocusListener implements FocusListener{

	
	private	JButton currentFocus;
	public static int flag;	
	
	@Override
	public void focusGained(FocusEvent e) {
		currentFocus= (DecoratedButton)e.getSource();
		if(currentFocus==MainMenu.play){
			System.out.println("lancer play");
			flag=GameStateManager.GAME;
		}		
		
		else if(currentFocus==MainMenu.load){
			System.out.println("lancer load");
			flag=GameStateManager.LOAD;
		}
		else if(currentFocus==MainMenu.instructions){
			System.out.println("lancer instructions");
			flag=GameStateManager.INSTRUCTIONS;
		}
		else if(currentFocus==MainMenu.scores){
			System.out.println("lancer scores");
			flag=GameStateManager.SCORES;

		}
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
