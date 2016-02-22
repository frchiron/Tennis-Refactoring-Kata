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
	private int firstPlayerScore = 0;
	private int secondPlayerScore = 0;

	public TennisGame1() {
	}

	public void wonPoint(String playerName) {
		if (playerName == PLAYER1)
			firstPlayerScore += 1;
		else
			secondPlayerScore += 1;
	}

	public String getScore() {

		boolean isEquality = firstPlayerScore == secondPlayerScore;
		if (isEquality) {
			return getScoreWhenEquality(firstPlayerScore);
		}

		boolean isAdvantageOrWin = firstPlayerScore > FORTY || secondPlayerScore > FORTY;
		if (isAdvantageOrWin) {
			return getScoreWhenAdvantageOrWin(firstPlayerScore, secondPlayerScore);
		}

		return getScoreWhenOtherCases(firstPlayerScore, secondPlayerScore);
	}

	public String getScoreWhenEquality(int playersScore) {
		if (playersScore > THIRTY) {
			return DEUCE;
		}
		return getScoreDisplay(playersScore) + SCORE_SEPARATOR + ALL;

	}

	public String getScoreWhenAdvantageOrWin(int firstPlayerScore, int secondPlayerScore) {
		String leadingOrWinningPlayer = firstPlayerScore - secondPlayerScore > 0 ? PLAYER1 : PLAYER2;
		String advantageOrWinFor = Math.abs(firstPlayerScore - secondPlayerScore) == 1 ? ADVANTAGE : WIN_FOR;
		return advantageOrWinFor + leadingOrWinningPlayer;

	}

	public String getScoreWhenOtherCases(int firstPlayerScore, int secondPlayerScore) {

		return getScoreDisplay(firstPlayerScore) + SCORE_SEPARATOR + getScoreDisplay(secondPlayerScore);
	}

	public String getScoreDisplay(int score) {
		switch (score) {
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
