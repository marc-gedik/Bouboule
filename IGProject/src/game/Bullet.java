package game;

import ui.Game;
import utils.AssetsManager;

import java.awt.image.BufferedImage;

public class Bullet extends Dynamic {

    private int direction;

    public Bullet(Body body, Character character) {
        super(body);
        this.direction = determineDirection(character);
        BufferedImage img = AssetsManager.getTexture("bullet");
        setAnimation(img, 0 / 12f);
    }

    public int getDirection() { return direction; }

    public int determineDirection(Character character) {
        int xC = character.getX();
        int yC = character.getY();
        int xB = this.getX();
        int yB = this.getY();
        int direction = Direction.None;

        if (character.getAngle()==0)
            direction += Direction.North;
        if (character.getAngle() == 90)
            direction += Direction.East;
        if (character.getAngle()==45)
            direction += Direction.East + Direction.North;
        if (character.getAngle()==180)
            direction += Direction.South;
        if (character.getAngle()==135)
            direction += Direction.East + Direction.South;
        if (character.getAngle()==-90)
            direction += Direction.West;
        if (character.getAngle()==-45)
            direction += Direction.North + Direction.West;
        if (character.getAngle()==-180)
            direction += Direction.South;
        if (character.getAngle()==-135)
            direction += Direction.South + Direction.West;
        return direction;
    }
}