package hackerrank

import java.util.*

class JesseAndCookies {
    fun cookies(k: Int, A: Array<Int>): Int {
        // Write your code here
        val heap = PriorityQueue<Int>()
        A.forEach {
            heap.offer(it)
        }
        var sum = 0
        while (heap.peek() < k  && heap.size >=2) {
            val a = heap.poll()
            val b = heap.poll()
            heap.offer(a + 2 * b)
            sum++
        }

        return if (heap.peek() >= k) sum else -1
    }
}