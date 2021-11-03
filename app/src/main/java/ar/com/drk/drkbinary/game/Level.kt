package ar.com.drk.drkbinary.game

class Level {
    var level = 1

    fun nextLevel() {
        level++
        if (level > 10) level = 10
    }

    fun getValue(): Int {
        val top = 0xF shl level
        return (0..top).random()
    }
}