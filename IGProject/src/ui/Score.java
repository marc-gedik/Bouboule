package ui;

public class Score {
	public final String name;
	public final long score;

	public Score(String name, long score) {
		super();
		this.name = name;
		this.score = score;
	}

	public boolean better(Long score) {
		return this.score < score;
	}
}
