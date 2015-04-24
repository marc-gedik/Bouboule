package game;

import ui.game.LevelRenderer;

public abstract class Dynamic extends GameObject {

	protected int idSprite = 0;
	protected double rotation = 0;

	protected int nbSprite = 3; // 4 en partant de 0
	int tmp=0;

	public Dynamic(int x, int y) {
		super(x, y);
	}


	void changeIdSprite(){

		if(tmp==3){
			if(idSprite==nbSprite)
				idSprite=0;
			else
				idSprite++;
			tmp=0;
		}
		else
			tmp++;

	}

	void move(int dir, int distance) {
		if ((dir & Direction.North) == Direction.North){
			y -= distance;	
			rotation=0;
			changeIdSprite();
		}
		if ((dir & Direction.South) == Direction.South){
			y += distance;
			rotation=2;
			changeIdSprite();
		}
		if ((dir & Direction.East) == Direction.East){
			x += distance;
			rotation=1;
			changeIdSprite();
		}
		if ((dir & Direction.West) == Direction.West){
			x -= distance;
			rotation=4;
			changeIdSprite();

		}


	}

}
