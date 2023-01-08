package linkedlist

import ListNode

class E83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var pointer = head
        while (pointer != null) {
            val data = pointer.`val`
            var next = pointer.next
            while (next != null && data == next.`val`) {
                next = next.next
            }

            pointer.next = next
            pointer = next
        }
        return head
    }
}