package linkedlists

import ListNode

class E0201 {
    fun removeDuplicateNodes(head: ListNode?): ListNode? {
        return head?.let {
            val set = mutableSetOf<Int>()
            var pointer = head
            set.add(head.`val`)

            while (pointer?.next != null) {
                val next = pointer.next
                if (!set.contains(next?.`val`)) {
                    set.add(next!!.`val`)
                    pointer = pointer.next
                } else {
                    pointer.next = next?.next
                }
            }

            head
        }
    }
}