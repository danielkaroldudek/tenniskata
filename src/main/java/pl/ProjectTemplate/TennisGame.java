package pl.ProjectTemplate;

public class TennisGame {
    private int playerOneScore;
    private int playerTwoScore;

    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        }

        if (isAfterDeuce()) {
            if(isAdvantageForPlayerOne()) {
                return "Advantage for Player One";
            }

            return "Advantage for Player Two";
        }

        if (playerOneScore > 3) {
            return "Player one won";
        } else if (playerTwoScore > 3) {
            return "Player two won";
        }

        return playerOneScore > 0 || playerTwoScore > 0 ? buildResultString() : "Love all";
    }


    public void playerScore(PlayerNumber playerNumber) {
        switch (playerNumber) {
            case ONE:
                playerOneScore();
                break;
            case TWO:
                playerTwoScore();
                break;
        }
    }
    private boolean isAdvantageForPlayerOne() {
        return playerOneScore - playerTwoScore == 1;
    }

    private boolean isAfterDeuce() {
        return playerOneScore >= 3 && playerTwoScore >= 3;
    }

    private String buildResultString() {
        return convertScoreToString(playerOneScore) + "," + convertScoreToString(playerTwoScore);
    }

    private boolean isDeuce() {
        return playerOneScore == 3 && playerOneScore == playerTwoScore;
    }

    private void playerOneScore() {
        playerOneScore++;
    }

    private void playerTwoScore() {
        playerTwoScore++;
    }

    private String convertScoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}

