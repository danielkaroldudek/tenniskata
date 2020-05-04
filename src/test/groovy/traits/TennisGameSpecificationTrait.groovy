package traits

import pl.ProjectTemplate.TennisGame

trait TennisGameSpecificationTrait {
    TennisGame tennisGame
    String result

    def setup() {
        tennisGame = new TennisGame()
    }

    def checkScore() {
        result = tennisGame.getScore()
    }
}