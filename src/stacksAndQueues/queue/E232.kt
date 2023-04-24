package stacksAndQueues.queue

import java.util.*

class E232 {
    private val s1: Stack<Int> = Stack()
    private val s2: Stack<Int> = Stack()
    private var front = -1
    fun push(x: Int) {
        if (s1.isEmpty()) {
            front = x
        }
        s1.push(x)
    }

    fun pop(): Int {
        while (s1.isNotEmpty()) {
            val obj = s1.pop()
            s2.push(obj)
        }
        val e = s2.pop()
        while (s2.isNotEmpty()) {
            val obj = s2.pop()
            if (s1.isEmpty()) {
                front = obj
            }
            s1.push(obj)
        }
        return e
    }

    fun peek(): Int {
        return front
    }

    fun empty(): Boolean {
        return s1.isEmpty()
    }
}