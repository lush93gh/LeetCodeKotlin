import kotlin.random.Random

class M470 {
    fun rand7(): Int {
        return Random.nextInt(0, 7) + 1
    }

    var count = 0
    private val list = listOf(1, 2, 3, 4, 5)

    fun rand10(): Int {
        val first = rand7()
        val sec = rand7()

        val group = if (first == sec) {
            10
        } else {
            if (sec in list) first
            else if (sec == 6 && first in list) 8
            else if (sec == 7 && first in list) 9
            else 10
        }

        return group
    }
}