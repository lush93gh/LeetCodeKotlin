package hackerrank

import java.util.*

class BalancedBrackets {
    fun isBalanced(s: String): String {
        // Write your code here
        val opens = listOf('(', '[', '{')
        val closes = listOf(')', ']', '}')
        val stack = Stack<Char>()
        s.forEach { c ->
            if (c in opens) {
                stack.push(c)
                println(stack)
            } else {
                if (stack.isNotEmpty()) {
                    val openIndex = opens.indexOf(stack.peek())
                    val closeIndex = closes.indexOf(c)
                    if (openIndex == closeIndex) {
                        stack.pop()
                    } else {
                        return "NO"
                    }
                } else {
                    return "NO"
                }
            }
        }
        return if (stack.isEmpty()) "YES" else "NO"
    }
}