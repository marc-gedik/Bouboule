package game;

public class Levels {
	private static int level;
	private static int maxLevel = 3;

	public static int getLevel() {
		return level;
	}

	public static boolean hasNext() {
		return level < maxLevel;
	}

	public static int next() {
		return ++level;
	}

}
