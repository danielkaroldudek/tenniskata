import spock.lang.Specification
import traits.TennisGameSpecificationTrait

class TennisGameSpecification extends Specification implements TennisGameSpecificationTrait {
    def "Start of the game should have score zero for both players"() {
        given: "I start new tennis game"
        when: "I check score"
            checkScore()
        then: "I should get 'Love all' as an output"
            "Love all" == result
    }

    def "First player scores"() {
        given: "First player scores"
            tennisGameFacade.playerScored(1)
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Love' as an output"
            "Fifteen,Love" == result
    }

    def "Second player scores"() {
        given: "Second player scores"
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Fifteen' as an output"
            "Love,Fifteen" == result
    }

    def "Second player scores twice"() {
        given: "Second player scores twice"
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Thirty' as an output"
            "Love,Thirty" == result
    }

    def "Second player scores three times"() {
        given: "Second player scores three times"
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Forty' as an output"
            "Love,Forty" == result
    }

    def "First player scores once and second player scores twice"() {
        given: "Second player scores once"
            tennisGameFacade.playerScored(1)
        and: "Player two scores twice"
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Thirty' as an output"
            "Fifteen,Thirty" == result
    }

    def "First player win when scores four times"() {
        given: "First player scores four times"
            tennisGameFacade.playerScored(1)
            tennisGameFacade.playerScored(1)
            tennisGameFacade.playerScored(1)
            tennisGameFacade.playerScored(1)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player one won'"
            "Player one won" == result
    }

    def "Second player win when scores four times"() {
        given: "Second player scored four times"
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player two won'"
            "Player two won" == result
    }

    def "Deuce state after each player scores three times"() {
        given: "Player one scores three times"
            playerOneWonThreeTimes()
        and: "Player two scores three times"
            playerTwoWonThreeTimes()
        when: "I check the score"
            checkScore()
        then: "I should get 'Deuce'"
            "Deuce" == result
    }

    private void playerTwoWonThreeTimes() {
        tennisGameFacade.playerScored(2)
        tennisGameFacade.playerScored(2)
        tennisGameFacade.playerScored(2)
    }

    private void playerOneWonThreeTimes() {
        tennisGameFacade.playerScored(1)
        tennisGameFacade.playerScored(1)
        tennisGameFacade.playerScored(1)
    }

    def "Advantage for player one when he scores after deuce"() {
        given: "There was a deuce"
            deuce()
        when: "Player one scores once after deuce"
            tennisGameFacade.playerScored(1)
        and: "I check the score"
            checkScore()
        then: "I should get 'Advantage for Player One'"
            "Advantage for Player One" == result
    }

    private void deuce() {
        playerOneWonThreeTimes()
        playerTwoWonThreeTimes()
    }

    def "Advantage for player two when he scores after deuce"() {
        given: "There was a deuce"
            deuce()
        when: "Player two scores once after deuce"
            tennisGameFacade.playerScored(2)
        and: "I check the score"
            checkScore()
        then: "I should get 'Advantage for Player Two'"
            "Advantage for Player Two" == result
    }

    def "Game won by player one after advantage"() {
        given: "There was a deuce"
            deuce()
        and: "Player one scores twice"
            tennisGameFacade.playerScored(1)
            tennisGameFacade.playerScored(1)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player one won'"
            "Player one won" == result
    }

    def "Game won by player two after advantage"() {
        given: "There was a deuce"
            deuce()
        and: "Player two scores twice"
            tennisGameFacade.playerScored(2)
            tennisGameFacade.playerScored(2)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player one won'"
            "Player two won" == result
    }
}
