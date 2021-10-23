package ar.com.drk.drkbinary

class GameService {

    data class Setup(val first: Int, val second: Int)

    var first = 1
    var second = 1
    var result = 2

    fun play() : Setup {
        first = (0..10).random()
        second = (0..10).random()
        result = first + second
        return Setup(first, second)
    }

    fun validate(answer: Int) : Boolean {
        return answer == result
    }
}