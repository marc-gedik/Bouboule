package game.objects.cakes;

import java.awt.image.BufferedImage;

import game.objects.Static;
import game.objects.weapons.Weapon;
import game.physics.Body;
import ui.game.LevelRenderer;
import utils.AssetsManager;

public abstract class Cake extends Static {
	private int levelCake;
	private BufferedImage img;

	public Cake(Body body) {
		super(body);
	}
	
	public BufferedImage getImg(){
		return this.img;
	}
	
	public abstract Weapon getWeapon();
	
	public void setImg(BufferedImage img){
	this.img=img;
	}
}
