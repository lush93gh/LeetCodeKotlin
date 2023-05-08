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

class SimpleTextEditor2 {
    private val stack = Stack<Char>()

    fun append(w: String) {
        w.forEach {
            stack.push(it)
        }
    }

    fun delete(k: Int): String {
        var toRemove = k
        var removedString = ""
        while (toRemove > 0) {
            if (stack.isNotEmpty()) {
                removedString = stack.pop() + removedString
                toRemove--
            }
        }
        return removedString
    }

    fun print(k: Int) {
        if (stack.isNotEmpty()) {
            println(stack[k-1])
        }
    }
}