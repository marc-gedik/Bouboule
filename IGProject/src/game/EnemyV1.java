package game;

import java.util.Random;

public class EnemyV1 extends Enemy{

	
	private  int dir = Direction.None;
	private int flag = 1000;
	private  int changeDirection =1000;
	public EnemyV1(Body body, int levelEnemy) {
		super(body, levelEnemy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void strategicMove(Character character) {
		
		Random rand = new Random();
		
		
		if(flag==changeDirection){
			dir = determineDirection(character);
			flag=0;
			changeDirection = rand.nextInt(1000 - 300) + 300;

		}
		else{
		flag++;
		}
		this.move(dir, 1);		
	}

	@Override
	public int determineDirection(Character character) {
		Random rand = new Random();
		int nbAleatoire = rand.nextInt(4) ;
		
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
		}
		
		
		
		return direction;
	}

}
