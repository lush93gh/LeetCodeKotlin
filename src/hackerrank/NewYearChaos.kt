package hackerrank

import java.util.*

class NewYearChaos {
    fun minimumBribes1(q: Array<Int>) {
        // Write your code here
        val qq = q.toMutableList()
        for (i in q.indices) {
            if (q[i] - (i + 1) > 2) {
                println("Too chaotic")
                return
            }
        }

        var sum = 0
        for (i in qq.indices) {
            val number = i + 1
            var targetIndex = i
            for (j in i until qq.size) {
                if (number == qq[j]) {
                    targetIndex = j
                    break
                }
            }

            for (j in targetIndex downTo number) {
                Collections.swap(qq, j - 1, j)
                sum++
            }

        }
        println("$sum")
    }

    fun minimumBribes(q: Array<Int>) {
        val qq = q.toMutableList()
        var sum = 0
        for (i in qq.size - 1 downTo 0) {
            val position = i + 1
            val num = qq[i]
            if (num != position) {
                if (i - 1 >= 0 && position == qq[i - 1]) {
                    Collections.swap(qq, i - 1, i)
                    sum++
                } else if (i - 2 >= 0 && position == qq[i - 2]) {
                    Collections.swap(qq, i - 2, i - 1)
                    Collections.swap(qq, i - 1, i)
                    sum += 2
                } else {
                    println("Too chaotic")
                    return
                }
            }
        }
        println("$sum")
    }
}