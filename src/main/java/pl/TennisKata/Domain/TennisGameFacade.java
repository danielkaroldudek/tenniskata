package pl.TennisKata.Domain;

public class TennisGameFacade {
    private final TennisGame tennisGame;

    public TennisGameFacade() {
        TennisGameFactory tennisGameFactory = new TennisGameFactory();
        tennisGame = tennisGameFactory.create();
    }

    public void playerScored(int playerNumber) {
        if (playerNumber == 1) {
            tennisGame.playerScore(PlayerNumber.ONE);
        } else {
            tennisGame.playerScore(PlayerNumber.TWO);
        }
    }

    public String getScore() {
        return tennisGame.getScore();
    }
}
