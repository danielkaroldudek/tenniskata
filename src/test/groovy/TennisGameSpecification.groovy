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
            tennisGame.playerOneScore()
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Love' as an output"
            "Fifteen,Love" == result
    }

    def "Second player scores"() {
        given: "Second player scores"
            tennisGame.playerTwoScore()
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Fifteen' as an output"
            "Love,Fifteen" == result
    }

    def "Second player scores twice"() {
        given: "Second player scores twice"
            tennisGame.playerTwoScore()
            tennisGame.playerTwoScore()
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Thirty' as an output"
            "Love,Thirty" == result
    }

    def "Second player scores three times"() {
        given: "Second player scores three times"
            tennisGame.playerTwoScore()
            tennisGame.playerTwoScore()
            tennisGame.playerTwoScore()
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Forty' as an output"
            "Love,Forty" == result
    }

    def "First player scores once and second player scores twice"() {
        given: "Second player scores once"
            tennisGame.playerOneScore()
        and: "Player two scores twice"
            tennisGame.playerTwoScore()
            tennisGame.playerTwoScore()
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Thirty' as an output"
            "Fifteen,Thirty" == result
    }


}
