import pl.ProjectTemplate.PlayerNumber
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
            tennisGame.playerScore(PlayerNumber.ONE)
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Love' as an output"
            "Fifteen,Love" == result
    }

    def "Second player scores"() {
        given: "Second player scores"
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Fifteen' as an output"
            "Love,Fifteen" == result
    }

    def "Second player scores twice"() {
        given: "Second player scores twice"
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Thirty' as an output"
            "Love,Thirty" == result
    }

    def "Second player scores three times"() {
        given: "Second player scores three times"
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Love,Forty' as an output"
            "Love,Forty" == result
    }

    def "First player scores once and second player scores twice"() {
        given: "Second player scores once"
            tennisGame.playerScore(PlayerNumber.ONE)
        and: "Player two scores twice"
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Fifteen,Thirty' as an output"
            "Fifteen,Thirty" == result
    }

    def "First player win when scores four times"() {
        given: "First player scores four times"
            tennisGame.playerScore(PlayerNumber.ONE)
            tennisGame.playerScore(PlayerNumber.ONE)
            tennisGame.playerScore(PlayerNumber.ONE)
            tennisGame.playerScore(PlayerNumber.ONE)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player one won'"
            "Player one won" == result
    }

    def "Second player win when scores four times"() {
        given: "Second player scored four times"
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Player two won'"
            "Player two won" == result
    }

    def "Deuce state after each player scores three times"() {
        given: "Player one scores three times"
            tennisGame.playerScore(PlayerNumber.ONE)
            tennisGame.playerScore(PlayerNumber.ONE)
            tennisGame.playerScore(PlayerNumber.ONE)
        and: "Player two scores three times"
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
            tennisGame.playerScore(PlayerNumber.TWO)
        when: "I check the score"
            checkScore()
        then: "I should get 'Deuce'"
            "Deuce" == result
    }
}
