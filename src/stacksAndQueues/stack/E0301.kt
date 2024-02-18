package stacksAndQueues.stack

class E0301(stackSize: Int) {
    private val stackSize = stackSize
    private val stacks = IntArray(stackSize * 3) { -1 }
    private var top0 = -1
    private var top1 = stackSize * 1 - 1
    private var top2 = stackSize * 2 - 1

    fun push(stackNum: Int, value: Int) {
        if (!isFull(stackNum)) {
            val top = when (stackNum) {
                1 -> ++top1
                2 -> ++top2
                else -> ++top0
            }
            stacks[top] = value
        }
    }

    fun pop(stackNum: Int): Int {
        return if (!isEmpty(stackNum)) {
            val top = when (stackNum) {
                1 -> top1--
                2 -> top2--
                else -> top0--
            }
            stacks[top]
        } else -1
    }

    fun peek(stackNum: Int): Int {
        return if (!isEmpty(stackNum)) {
            val top = when (stackNum) {
                1 -> top1
                2 -> top2
                else -> top0
            }
            stacks[top]
        } else -1
    }

    fun isEmpty(stackNum: Int): Boolean {
        val top = when (stackNum) {
            1 -> top1
            2 -> top2
            else -> top0
        }
        return top == stackNum * stackSize - 1
    }

    private fun isFull(stackNum: Int): Boolean {
        val top = when (stackNum) {
            1 -> top1
            2 -> top2
            else -> top0
        }
        return top >= stackNum * stackSize + stackSize - 1
    }
}