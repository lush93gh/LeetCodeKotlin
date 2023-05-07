package hackerrank

import java.util.*

class QueueUsingTwoStacks {
    class Queue() {
        private val s1 = Stack<Int>()
        private val s2 = Stack<Int>()
        private var s1Front = -1

        fun enqueue(item: Int) {
            if (s1.isEmpty()) {
                s1Front = item
            }
            s1.push(item)
        }

        fun peek() {
            if (s2.isNotEmpty()) {
                println("${s2.peek()}")
            } else {
                println("$s1Front")
            }
        }

        fun dequeue() {
            if (s2.isNotEmpty()) {
                s2.pop()
            } else {
                while (s1.isNotEmpty()) {
                    val item = s1.pop()
                    s2.push(item)
                }
                s2.pop()
            }
        }
    }
}