package utils;

import game.Direction;

public class MathUtils {

	public static double dist2(double xA, double xB, double yA, double yB) {
		double distX = xA - xB;
		distX *= distX;
		double distY = yA - yB;
		distY *= distY;
		return distX + distY;
	}
	
	public static float dirToAngle(int dir){
		switch (dir) {
		case Direction.North: return 270;
		case Direction.South: return 90;
		case Direction.East:  return 0;
		case Direction.West:  return 180;
		case Direction.NEast: return 315;
		case Direction.NWest: return 225;
		case Direction.SEast: return 45;
		case Direction.SWest: return 135;
		default:
			return 0;
		}
	}
}
