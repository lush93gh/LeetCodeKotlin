package sortingAndSearching

import java.util.*

class E703(k: Int, nums: IntArray) {
    private val k = k
    private val queue = PriorityQueue(nums.asList())
    private var lastResult = -Int.MAX_VALUE

    fun add(`val`: Int): Int {
        if (`val` <= lastResult) {
            return lastResult
        }
        queue.offer(`val`)
        for (i in 0 until queue.size - k) {
            queue.poll()
        }
        return queue.peek()
    }
}