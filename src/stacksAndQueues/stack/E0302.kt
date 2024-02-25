package stacksAndQueues.stack

import java.util.*

class E0302 {
    private val stack = mutableListOf<Int>()
    private val dequeue: Deque<Int> = LinkedList()

    fun push(x: Int) {
        stack.add(x)
        val min = dequeue.peekFirst() ?: Int.MAX_VALUE
        if (x <= min) {
            dequeue.offerFirst(x)
        } else {
            dequeue.offerLast(x)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val e = stack.removeLast()
            if (dequeue.peekFirst() == e) {
                dequeue.pollFirst()
            } else {
                dequeue.pollLast()
            }
        }
    }

    fun top(): Int {
        return if (stack.isNotEmpty()) {
            stack.last()
        } else {
            -1
        }
    }

    fun getMin(): Int {
        return dequeue.peekFirst()
    }
}