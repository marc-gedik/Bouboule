package game;

import game.objects.Character;
import controler.LoadMenuListener;

public class Conductor {

	private static Character character;

	public static void reset() {
		Levels.setLevel(0);
		character = null;
	}

	public static Level initGame() {
		if(character == null)
			character = new Character();
		if (LoadMenuListener.loadRequested())
			return LoadLevel.getSavedLevel(LoadMenuListener.getInfoLevel(), character);
		else
			return LoadLevel.get(Levels.getLevel(), character);
	}

	public static long getScore(){
		return character.getScore();
	}
}
