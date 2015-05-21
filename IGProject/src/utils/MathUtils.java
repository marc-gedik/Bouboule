package utils;

public class MathUtils {

	public static double dist2(double xA, double xB, double yA, double yB) {
		double distX = xA - xB;
		distX *= distX;
		double distY = yA - yB;
		distY *= distY;
		return distX + distY;
	}
	
}
