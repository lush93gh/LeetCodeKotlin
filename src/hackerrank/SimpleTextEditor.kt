package hackerrank

import java.util.*

class SimpleTextEditor {
    private val stack = Stack<String>()

    init {
        stack.push("")
    }

    fun append(w: String) {
        if (stack.isNotEmpty()) {
            stack.push(stack.peek() + w)
        }
    }

    fun delete(k: Int) {
        if (stack.isNotEmpty()) {
            stack.push(stack.peek().dropLast(k))
        }
    }

    fun print(k: Int) {
        if (stack.isNotEmpty()) {
            println(stack.peek()[k - 1])
        }
    }

    fun undo() {
        stack.pop()
    }
}