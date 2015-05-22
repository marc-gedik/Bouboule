package game.physics;

public class Category {
	public static final short 
	Character = 0b1,
	Wall      = 0b10,
	Enemy     = 0b100,
	Bullet    = 0b1000,
	Cake      = 0b10000;

	public static boolean isBullet(short id) {
		return is(id, Bullet);
	}

	private static boolean is(short id, short what) {
		return (id & what) == what;
	}

	public static boolean isEnemy(short id) {
		return is(id, Enemy);
	}

	public static boolean isCharacter(short id) {
		return is(id, Character);
		}
	
	
	public static boolean isCake(short id) {
		return is(id, Cake);
	}

	public static boolean isIn(short mask, short category) {
		return (mask & category) > 0; 
	}
}
