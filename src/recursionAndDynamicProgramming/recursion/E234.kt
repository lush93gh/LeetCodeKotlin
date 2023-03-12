package recursionAndDynamicProgramming.recursion

import ListNode

class E234 {
    fun isPalindrome(head: ListNode?): Boolean {
        val list = mutableListOf<Int>()
        var root = head
        head?.let {
            list.add(it.`val`)
            while (root?.next != null) {
                root?.next?.let {
                    root = it
                    list.add(it.`val`)
                }
            }

            list.forEachIndexed { index, num ->
                if (num != list[list.size - 1 - index]) return false
            }
        }
        return true
    }
}