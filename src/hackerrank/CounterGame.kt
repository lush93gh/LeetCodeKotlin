package hackerrank

import kotlin.math.log2
import kotlin.math.pow

class CounterGame {
    fun counterGame1(n: Long): String {
        // Write your code here
        var player = true
        var number = n
        while (number > 1L) {
            val log = log2(number.toDouble())
            val revert = 2.0.pow(log.toLong().toDouble())
            //  println("$log $revert")
            if (revert == number.toDouble()) {
                number /= 2L
            } else {
                number -= revert.toLong()
            }
            //  println("$number")
            player = !player
        }
        player = if (number == 1L) !player else player
        return if (player) "Louise" else "Richard"
    }

    fun counterGame(n: Long): String {
        // Write your code here
        var player = true
        var number = n.toString(2)
        while (number.length > 1) {
            val ones = number.filter { it == '1' }.length
            if (ones > 1) {
                number = number.drop(1).trimStart { it == '0' }
            } else {
                val zeros = number.filter { it == '0' }.length
                if (zeros % 2 == 1) {
                    player = !player
                }
                number = "1"
            }
            //  println("$number")
            player = !player
        }
        player = if (number.length == 1) !player else player
        return if (player) "Louise" else "Richard"
    }
}