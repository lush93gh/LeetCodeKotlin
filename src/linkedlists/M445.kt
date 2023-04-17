package linkedlists

import ListNode
import java.util.*

// 445. Add Two Numbers II
class M445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val s1 = Stack<Int>()
        val s2 = Stack<Int>()

        var pointer = l1
        while (pointer != null) {
            s1.push(pointer.`val`)
            pointer = pointer.next
        }

        pointer = l2
        while (pointer != null) {
            s2.push(pointer.`val`)
            pointer = pointer.next
        }

        val root = ListNode(0)
        pointer = root
        var carry = 0
        while (s1.isNotEmpty() || s2.isNotEmpty()) {
            val num1 = if (s1.isNotEmpty()) s1.pop() else 0
            val num2 = if (s2.isNotEmpty()) s2.pop() else 0
            val sum = num1 + num2 + carry
            pointer!!.`val` = sum % 10
            val node = ListNode(0)
            node.next = pointer
            carry = sum / 10
            pointer = node
        }
        return pointer
    }

    private fun reverse(root: ListNode?, l1: ListNode?): ListNode {
        if (l1?.next != null) {
            reverse(root, l1.next).next = l1
        } else {
            root!!.next = l1
        }
        return l1!!
    }

    private fun add(root: ListNode, l1: ListNode?, l2: ListNode?): Int {
        return if (l1?.next != null || l2?.next != null) {
            root.next = ListNode(0)
            if (l1?.next != null && l2?.next == null) {
                val sum = l1.`val` + add(root.next!!, l1.next, l2)
                root.`val` = sum % 10
                sum / 10
            } else if (l1?.next == null && l2?.next != null) {
                val sum = l2.`val` + add(root.next!!, l1, l2.next)
                root.`val` = sum % 10
                sum / 10
            } else {
                val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + add(root.next!!, l1?.next, l2?.next)
                root.`val` = sum % 10
                sum / 10
            }
        } else {
            val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
            root.`val` = sum % 10
            sum / 10
        }
    }
}