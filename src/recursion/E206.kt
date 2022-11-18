package recursion

import ListNode

class E206 {
    var result: ListNode? = null
    fun reverseList(head: ListNode?): ListNode? {
        recurse(head)
        head?.next = null
        return result
    }

    fun recurse(head: ListNode?) {
        if (head?.next != null) {
            recurse(head.next)
            head.next?.next = head
        }
        else result = head
        (0..8).random()
    }
}