
public class TennisGame1 implements TennisGame {

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

		boolean isAdvantageOrWin = firstPlayerScore >= 4 || secondPlayerScore >= 4;
		if (isAdvantageOrWin) {
			return getScoreWhenAdvantageOrWin();
		}

		return getScoreWhenOtherCases(firstPlayerScore, secondPlayerScore);
	}

	public String getScoreWhenOtherCases(int firstPlayerScore, int secondPlayerScore) {

		return convertPlayerScoreToLitteral(firstPlayerScore) + SCORE_SEPARATOR
				+ convertPlayerScoreToLitteral(secondPlayerScore);
	}

	public String convertPlayerScoreToLitteral(int playerScore) {
		switch (playerScore) {
		case 0:
			return LOVE;
		case 1:
			return FIFTEEN;
		case 2:
			return THIRTY;
		case 3:
			return FORTY;
		default:
			return EMPTY;
		}
	}

	public String getScoreWhenAdvantageOrWin() {
		String score = EMPTY;
		int minusResult = firstPlayerScore - secondPlayerScore;
		if (minusResult == 1)
			score = "Advantage player1";
		else if (minusResult == -1)
			score = "Advantage player2";
		else if (minusResult >= 2)
			score = "Win for player1";
		else
			score = "Win for player2";

		return score;
	}

	public String getScoreWhenEquality(int playersScore) {
		String score;
		switch (playersScore) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}
		return score;
	}
}
