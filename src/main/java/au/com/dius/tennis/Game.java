package au.com.dius.tennis;

/**
 * Tennis game tournament (coding style example)
 *
 * @author Martin Janousek
 */
public class Game {
	private Player player1;
	private Player player2;
	private boolean deuce;

	public Game(String player1, String player2) {
		// assertHasText(player1)
		// assertHasText(player2)
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
	}

	/**
	 * Register next point in game. Here is defined most of tennis game's logic
	 * 
	 * @param name
	 *            Player's name
	 */
	public void pointWonBy(String name) {
		Player player = getPlayerByName(name);

		if (player.getScore().isMax()) {
			if (isOnePointToVictory(player)) {
				player.setWinner(true);
			} else {
				manageAdvantage(player);
			}
		} else {
			player.addPoint();
		}
		this.deuce = isDeuce();
	}

	/**
	 * Returns current score
	 */
	public String getScore() {
		if (player1.isWinner()) {
			return player1.getName() + " wins";
		}

		if (player2.isWinner()) {
			return player2.getName() + " wins";
		}

		if (player1.hasAdvantage()) {
			return "Advantage " + player1.getName();
		}

		if (player2.hasAdvantage()) {
			return "Advantage " + player2.getName();
		}

		if (deuce) {
			return "Deuce";
		}
		return player1.getScore() + "-" + player2.getScore();
	}

	/**
	 * Both players can't have advantage at the same moment. This method ensure
	 * correct advantage setting
	 * 
	 * @param player
	 *            Player who won last point
	 */
	private void manageAdvantage(Player player) {
		Player opponent = getOpponent(player);
		if (opponent.hasAdvantage()) {
			opponent.setAdvantage(false);
		} else {
			player.setAdvantage(true);
		}
	}

	/**
	 * Is player missing one point to victory? Player must score two points more
	 * than opponent to get victory
	 * 
	 * @param player
	 *            Player who won last point
	 */
	private boolean isOnePointToVictory(Player player) {
		int pointDiff = player.getScore().getPointDiff(
				getOpponent(player).getScore());
		return pointDiff >= 2 || player.hasAdvantage();
	}

	/**
	 * Deuce is when score equeals 40-40
	 */
	private boolean isDeuce() {
		return player1.getScore() == Score.FORTY
				&& player2.getScore() == Score.FORTY;
	}

	private Player getPlayerByName(String name) {
		// assertHasText(name)
		if (name.equalsIgnoreCase(player1.getName())) {
			return player1;
		}

		if (name.equalsIgnoreCase(player2.getName())) {
			return player2;
		}
		throw new IllegalArgumentException("Unknown player name: " + name);
	}

	private Player getOpponent(Player player) {
		// assertNotNull(player)
		if (player.equals(player1)) {
			return player2;
		}

		if (player.equals(player2)) {
			return player1;
		}
		throw new IllegalArgumentException("Unknown player in game: " + player);
	}
}