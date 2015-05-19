package game;

public class Direction {
	public static final int
	None = 0b0000,
	North = 0b0001,
	South = 0b0010,
	East = 0b0100,
	West = 0b1000,

	NEast = North | East,
	NWest = North | West,
	
	SEast = South | East,
	SWest = South | West;
	
}
