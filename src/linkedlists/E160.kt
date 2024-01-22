package linkedlists

import ListNode

class E160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val table = mutableSetOf<Int>()
        var pointer = headA
        while (pointer != null) {
            table.add(pointer.hashCode())
            pointer = pointer.next
        }
        pointer = headB
        while (pointer != null) {
            if (table.contains(pointer.hashCode())) {
                return pointer
            }
            pointer = pointer.next
        }
        return null
    }
}