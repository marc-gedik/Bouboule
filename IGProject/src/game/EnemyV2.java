package game;

import java.util.Random;

public class EnemyV2 extends Enemy {
	
	
	private  int dir = Direction.None;
	private  int flag = 500;
	private  int changeDirection =500;
	
	public EnemyV2(Body body, int levelEnemy) {
		super(body, levelEnemy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void strategicMove(Character character) {
		Random rand = new Random();
		
		
		if(flag==changeDirection){
			dir = determineDirection(character);
			flag=0;
			changeDirection = rand.nextInt(500 - 300) + 300;

		}
		else{
		flag++;
		}
		this.move(dir, 1);
		
	}

	@Override
	public int determineDirection(Character character) {
		Random rand = new Random();
		int nbAleatoire = rand.nextInt(8) ;
		int direction= Direction.None;
		
		switch(nbAleatoire){
		case 0:
			direction = Direction.South;
			break;
		case 1:
			direction = Direction.North;
			break;
		case 2:
			direction = Direction.West;
			break;
		case 3:
			direction = Direction.East;
			break;
		case 4:
			direction = Direction.North;
			direction += Direction.East;
			break;
		case 5:
			direction = Direction.South;
			direction += Direction.East;
			break;
		case 6:
			direction = Direction.North;
			direction += Direction.West;
			break;
		case 7:
			direction = Direction.South;
			direction += Direction.West;
			break;
		}
		
		
		
		return direction;
	}
	

}
