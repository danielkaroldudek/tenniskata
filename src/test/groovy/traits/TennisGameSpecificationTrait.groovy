package traits

import pl.TennisKata.Domain.TennisGameFacade

trait TennisGameSpecificationTrait {
    TennisGameFacade tennisGameFacade
    String result

    def setup() {
        tennisGameFacade = new TennisGameFacade()
    }

    def checkScore() {
        result = tennisGameFacade.getScore()
    }
}