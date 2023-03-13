package linkedlists

import ListNode

class M2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = ListNode(0)
        var p1 = l1
        var p2 = l2
        var pointer = root
        var carry = 0

        while (p1 != null || p2 != null || carry > 0) {
            val num1 = p1?.`val` ?: 0
            val num2 = p2?.`val` ?: 0
            val sum = num1 + num2 + carry
            carry = sum / 10
            pointer.next = ListNode(sum % 10)
            pointer = pointer.next!!
            p1 = p1?.next
            p2 = p2?.next
        }

        return root.next
    }
}