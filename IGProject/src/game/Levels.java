package game;

public class Levels {
	private static int level;
	private static int maxLevel = 4;

	public static int getLevel() {
		return level;
	}

	public static boolean hasNext() {
		return level + 1 < maxLevel;
	}

	public static int next() {
		return ++level;
	}

	public static void setLevel(int levelID) {
		level = levelID;
	}

}
