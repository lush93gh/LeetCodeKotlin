package stacksAndQueues.stack

import java.util.*

// 225. Implement Stack using Queues
class E225 {
    private val queue1: Queue<Int> = LinkedList()
    private val queue2: Queue<Int> = LinkedList()
    private var top = -1
    fun push(x: Int) {
        top = x
        queue1.offer(x)
    }

    fun pop(): Int {
        while (queue1.size > 1) {
            val obj = queue1.poll()
            queue2.offer(obj)
        }
        val e = queue1.poll()
        while (queue2.isNotEmpty()) {
            val obj = queue2.poll()
            top = obj
            queue1.offer(obj)
        }
        return e
    }

    fun top(): Int {
        return top
    }

    fun empty(): Boolean {
        return queue1.isEmpty()
    }
}