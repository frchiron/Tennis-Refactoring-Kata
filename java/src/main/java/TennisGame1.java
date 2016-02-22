
public class TennisGame1 implements TennisGame {

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
			return getScoreWhenEquality();
		}

		boolean isAdvantageOrWin = firstPlayerScore >= 4 || secondPlayerScore >= 4;
		if (isAdvantageOrWin) {
			return getScoreWhenAdvantageOrWin();
		}

		String score = "";
		for (int i = 1; i < 3; i++) {
			int tempScore = 0;
			if (i == 1)
				tempScore = firstPlayerScore;
			else {
				score += "-";
				tempScore = secondPlayerScore;
			}
			switch (tempScore) {
			case 0:
				score += LOVE;
				break;
			case 1:
				score += FIFTEEN;
				break;
			case 2:
				score += THIRTY;
				break;
			case 3:
				score += FORTY;
				break;
			}
		}
		return score;
	}

	public String getScoreWhenAdvantageOrWin() {
		String score = "";
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

	public String getScoreWhenEquality() {
		String score;
		switch (firstPlayerScore) {
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
