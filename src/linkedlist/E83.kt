package linkedlist

import ListNode

// 83. Remove Duplicates from Sorted List
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