package linkedlist

import ListNode

// 1290. Convert Binary Number in a Linked List to Integer
class E1290 {
    fun getDecimalValue(head: ListNode?): Int {
        var count = 0
        var pointer = head
        while (pointer != null) {
            count++
            pointer = pointer.next
        }

        var result = 0
        pointer = head
        while (pointer != null) {
            result += pointer.`val` shl (count - 1)
            count--
            pointer = pointer.next
        }
        return result
    }
}