package game.objects;

import game.Direction;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;

public class Bullet extends Dynamic {

    private int direction;

    public Bullet(Body body, Character character) {
        super(body, 15);
        this.direction = determineDirection(character);
        BufferedImage img = AssetsManager.getTexture("bullet");
        setAnimation(img, 0 / 12f);
    }

    public int determineDirection(Character character) {
        int direction = Direction.None;

        if (character.getAngle()==0)
            direction = Direction.North;
        else if (character.getAngle() == 90)
            direction = Direction.East;
        else if (character.getAngle()==45)
            direction = Direction.East + Direction.North;
        else if (character.getAngle()==180)
            direction = Direction.South;
        else if (character.getAngle()==135)
            direction = Direction.East + Direction.South;
        else if (character.getAngle()==-90)
            direction = Direction.West;
        else if (character.getAngle()==-45)
            direction = Direction.North + Direction.West;
        else if (character.getAngle()==-180)
            direction = Direction.South;
        else if (character.getAngle()==-135)
            direction = Direction.South + Direction.West;
        return direction;
    }
    
    @Override
    public void update(float dt) {
    	super.update(dt);
		move(direction);
    }
}