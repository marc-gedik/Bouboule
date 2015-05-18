package game;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;

public class EnemyV3 extends Enemy {


	private int lastX=0, lastY=0, lastDIR=0;
	private int cpt=0;
	private int sizeBypass= 50;
	private boolean flag =true;
	private int dir=Direction.None;
	public EnemyV3(Body body) {
		super(body);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v3", 4);
		setAnimation(img, 1000 / 12f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void strategicMove(Character character) {
		Random rand = new Random();
		




		if(body.getX()==lastX && body.getY()==lastY){
			dir= bypass(lastDIR);
			flag=false;
		}

		if(flag)
			dir = determineDirection(character);
		else{
			cpt++;
			if(cpt==sizeBypass){
				flag=true;
				cpt=0;
			}

		}




		lastX = body.getX();
		lastY = body.getY();
		lastDIR = dir;
		this.move(dir, 1);

	}

	@Override
	public int determineDirection(Character character) {
		int xC = character.getX();
		int yC = character.getY();
		int xE = this.getX();
		int yE = this.getY();
		int direction = Direction.None;

		if (yC > yE)
			direction += Direction.South;
		else if (yC < yE)
			direction += Direction.North;
		if (xC > xE)
			direction += Direction.East;
		if (xC < xE)
			direction += Direction.West;
		return direction;
	}





	public int oppositeDirection(int d) {

		int direction = Direction.None;
		switch (d) {
		case 0:
			direction = Direction.None;
			break;
		case 1:
			direction = Direction.South;
			break;
		case 2:
			direction = Direction.North;
			break;
		case 4:
			direction = Direction.West;
			break;
		case 5:
			direction = Direction.South;
			direction += Direction.West;
			break;
		case 6:
			direction = Direction.North;
			direction += Direction.West;
			break;
		case 8:
			direction += Direction.East;
			break;
		case 9:
			direction = Direction.South;
			direction += Direction.East;
			break;
		case 10:
			direction = Direction.North;
			direction += Direction.East;
			break;
		}

		return direction;
	}


	public int bypass(int lastDIR){
		int direction = oppositeDirection(lastDIR);
		direction+=Direction.West;
		return direction;
	}



}
