package utils;

public class MathUtils {

	public static int dist2(int xA, int xB, int yA, int yB) {
		int distX = xA - xB;
		distX *= distX;
		int distY = yA - yB;
		distY *= distY;
		return distX + distY;
	}
	
}
