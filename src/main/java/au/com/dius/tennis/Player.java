package au.com.dius.tennis;

public class Player {
	private String name;
	private Score score;
	private boolean advantage;
	private boolean winner;

	public Player() {
		this.score = Score.ZERO;
	}

	public Player(String name) {
		this();
		this.name = name;
	}

	public void addPoint() {
		setScore(score.addPoint());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public boolean hasAdvantage() {
		return advantage;
	}

	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}