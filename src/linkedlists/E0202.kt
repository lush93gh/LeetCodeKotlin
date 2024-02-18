package linkedlists

import ListNode

class E0202 {
    fun kthToLast(head: ListNode?, k: Int): Int {
        var pointer = head
        var count = 0
        while (pointer != null) {
            count++

            pointer = pointer.next
        }

        pointer = head
        for (i in 1 until (count - k + 1)) {
            pointer = pointer?.next
        }

        return pointer!!.`val`
    }
}