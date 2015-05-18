package game;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;

public class EnemyV1 extends Enemy{

	
	private  int dir = Direction.None;
	private int flag = 1000;
	private  int changeDirection =1000;
	private int lastX=0, lastY=0;
	public EnemyV1(Body body) {
		super(body);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v1", 4);
		setAnimation(img, 1000 / 12f);
		// TODO Auto-generated constructor stub
	
	}
	

	@Override
	public void strategicMove(Character character) {
		//System.out.println(body.getX()+ " " + body.getY());
		
		
		
		Random rand = new Random();
		
		if(body.getX()==lastX && body.getY()==lastY){
			flag=changeDirection;
		}
		
		if(flag==changeDirection){
			dir = determineDirection(character);
			flag=0;
			changeDirection = rand.nextInt(800);

		}
		else{
		flag++;
		}
		
		lastX = body.getX();
		lastY = body.getY();
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
