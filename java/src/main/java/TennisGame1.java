
public class TennisGame1 implements TennisGame {

	private static final String PLAYER2 = "player2";
	private static final String WIN_FOR = "Win for ";
	private static final String ADVANTAGE = "Advantage ";
	private static final int _4 = 4;
	private static final int _3 = 3;
	private static final int _0 = 0;
	private static final int _1 = 1;
	private static final int _2 = 2;
	private static final String DEUCE = "Deuce";
	private static final String ALL = "All";
	private static final String EMPTY = "";
	private static final String SCORE_SEPARATOR = "-";
	private static final String FORTY = "Forty";
	private static final String THIRTY = "Thirty";
	private static final String FIFTEEN = "Fifteen";
	private static final String LOVE = "Love";
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

		boolean isAdvantageOrWin = firstPlayerScore >= _4 || secondPlayerScore >= _4;
		if (isAdvantageOrWin) {
			return getScoreWhenAdvantageOrWin(firstPlayerScore, secondPlayerScore);
		}

		return getScoreWhenOtherCases(firstPlayerScore, secondPlayerScore);
	}

	public String getScoreWhenOtherCases(int firstPlayerScore, int secondPlayerScore) {

		return convertPlayerScoreToLitteral(firstPlayerScore) + SCORE_SEPARATOR
				+ convertPlayerScoreToLitteral(secondPlayerScore);
	}

	public String convertPlayerScoreToLitteral(int playerScore) {
		switch (playerScore) {
		case _0:
			return LOVE;
		case _1:
			return FIFTEEN;
		case _2:
			return THIRTY;
		case _3:
			return FORTY;
		default:
			return EMPTY;
		}
	}

	public String getScoreWhenAdvantageOrWin(int firstPlayerScore, int secondPlayerScore) {
		int scoreDifference = firstPlayerScore - secondPlayerScore;
		String leadingOrWinningPlayer = scoreDifference > 0 ? PLAYER1 : PLAYER2;
		String advantageOrWinFor = Math.abs(scoreDifference) == 1 ? ADVANTAGE : WIN_FOR;
		return advantageOrWinFor + leadingOrWinningPlayer;

	}

	public String getScoreWhenEquality(int playersScore) {
		if (playersScore > _2) {
			return DEUCE;
		}
		return convertPlayerScoreToLitteral(playersScore) + SCORE_SEPARATOR + ALL;

	}
}
