package game;

public class BodyId {
	public static final short 
	Character = 0b0001,
	Wall = 0b0010, 
	Enemy = 0b0100,
	Bullet = 0b1000;
	
	public static boolean isBullet(short id){
		return is(id, Bullet);
	}

	private static boolean is(short id, short what) {
		return (id & what) == what;
	}

	public static boolean isEnemy(short id) {
		return is(id, Enemy);
	}
}
