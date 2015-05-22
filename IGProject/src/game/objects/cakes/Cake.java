package game.objects.cakes;

import game.objects.Character;
import game.objects.Static;
import game.physics.Body;

import java.awt.image.BufferedImage;

public abstract class Cake extends Static {
	private int levelCake;
	private BufferedImage img;

	public Cake(Body body) {
		super(body);
	}
	
	public BufferedImage getImg(){
		return this.img;
	}
	
	public abstract void power(Character character);
	
	public void setImg(BufferedImage img){
	this.img=img;
	}
}
