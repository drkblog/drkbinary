package ar.com.drk.drkbinary.game

class GameService {

    data class Setup(val first: Int, val second: Int)

    val level = Level()

    var round = 0
    var first = 1
    var second = 1
    var result = 2

    fun play() : Setup {
        advanceRoundAndLevel()
        first = level.getValue()
        second = level.getValue()
        result = first + second
        return Setup(first, second)
    }

    private fun advanceRoundAndLevel() {
        round++
        if (round % 10 == 0) {
            level.nextLevel()
        }
    }

    fun validate(answer: Int) : Boolean {
        return answer == result
    }
}