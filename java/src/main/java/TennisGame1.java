public class TennisGame1 implements TennisGame {

	private static final String PLAYER2 = "player2";
	private static final String WIN_FOR = "Win for ";
	private static final String ADVANTAGE = "Advantage ";
	private static final int FORTY = 3;
	private static final int LOVE = 0;
	private static final int FIFTEEN = 1;
	private static final int THIRTY = 2;
	private static final String DEUCE = "Deuce";
	private static final String ALL = "All";
	private static final String EMPTY = "";
	private static final String SCORE_SEPARATOR = "-";
	private static final String FORTY_DISPLAY = "Forty";
	private static final String THIRTY_DISPLAY = "Thirty";
	private static final String FIFTEEN_DISPLAY = "Fifteen";
	private static final String LOVE_DISPLAY = "Love";
	private static final String PLAYER1 = "player1";
	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame1() {
		firstPlayer = new Player(PLAYER1);
		secondPlayer = new Player(PLAYER2);
	}

	public void wonPoint(String playerName) {
		if (PLAYER1.equals(playerName)) {
			firstPlayer.score();
		} else {
			secondPlayer.score();
		}
	}

	public String getScore() {

		if (firstPlayer.isEqualityWith(secondPlayer)) {
			return getScoreWhenEquality(firstPlayer.getScore());
		}

		boolean isAdvantageOrWin = firstPlayer.getScore() > FORTY || secondPlayer.getScore() > FORTY;
		if (isAdvantageOrWin) {
			return getScoreWhenAdvantageOrWin();
		}

		return getScoreWhenOtherCases();
	}

	public String getScoreWhenEquality(int playersScore) {
		if (firstPlayer.getScore() > THIRTY) {
			return DEUCE;
		}
		return firstPlayer.getScoreDisplay() + SCORE_SEPARATOR + ALL;

	}

	public String getScoreWhenAdvantageOrWin() {
		String leadingOrWinningPlayer = firstPlayer.isLeadingOrWinningVs(secondPlayer) ? firstPlayer.getName()
				: secondPlayer.getName();
		String advantageOrWinFor = Math.abs(firstPlayer.getScore() - secondPlayer.getScore()) == 1 ? ADVANTAGE
				: WIN_FOR;
		return advantageOrWinFor + leadingOrWinningPlayer;

	}

	public String getScoreWhenOtherCases() {

		return firstPlayer.getScoreDisplay() + SCORE_SEPARATOR + secondPlayer.getScoreDisplay();
	}

	public class Player {
		private String name;
		private Score score;

		public Player(String name) {
			this.name = name;
			this.score = new Score();
		}

		public void score() {
			this.score.addPoint();
		}

		public int getScore() {
			return score.value;
		}

		public String getName() {
			return name;
		}

		public boolean isLeadingOrWinningVs(Player otherPlayer) {
			return this.getScore() - otherPlayer.getScore() > 0;
		}

		public boolean isEqualityWith(Player otherPlayer) {
			return this.getScore() == otherPlayer.getScore();
		}

		public String getScoreDisplay() {
			return score.getDisplay();
		}

		private class Score {

			int value;

			public Score() {
				value = 0;
			}

			public void addPoint() {
				value++;

			}

			public String getDisplay() {
				switch (value) {
				case LOVE:
					return LOVE_DISPLAY;
				case FIFTEEN:
					return FIFTEEN_DISPLAY;
				case THIRTY:
					return THIRTY_DISPLAY;
				case FORTY:
					return FORTY_DISPLAY;
				default:
					return EMPTY;
				}
			}
		}

	}
}
