package pl.ProjectTemplate;

public class TennisGame {
    private int playerOneScore;
    private int playerTwoScore;

    public String getScore() {
        if (playerOneScore > 3) {
            return "Player one won";
        } else if (playerTwoScore > 3) {
            return "Player two won";
        }

        String scoreString = convertScoreToString(playerOneScore) + "," + convertScoreToString(playerTwoScore);

        return playerOneScore > 0 || playerTwoScore > 0 ? scoreString : "Love all";
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

