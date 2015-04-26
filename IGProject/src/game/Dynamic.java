package game;

import ui.game.LevelRenderer;

public abstract class Dynamic extends GameObject {

	protected int idSprite = 0;
	protected double rotation = 0;

	protected int nbSprite = 3; // 4 en partant de 0
	int tmp=0;

	public Dynamic(Body body) {
		super(body);
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
		int x = 0, y = 0;
		
		if ((dir & Direction.North) == Direction.North){
			y -= distance;	
			rotation=0;
			changeIdSprite();
		}
		if ((dir & Direction.South) == Direction.South){
			y += distance;
			rotation= 3;
			changeIdSprite();
		}
		if ((dir & Direction.East) == Direction.East){
			x += distance;
			rotation=1.5;
			changeIdSprite();
		}
		if ((dir & Direction.West) == Direction.West){
			x -= distance;
			rotation=4.5;
			changeIdSprite();
		}

		body.applyForce(x, y);
	}

}
