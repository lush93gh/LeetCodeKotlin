package linkedlist

import ListNode

class E876 {
    var depth = 0
    var result: ListNode? = null
    fun middleNode(head: ListNode?): ListNode? {
        recurse(head, 1)
        return result
    }

    fun recurse(head: ListNode?, currentDepth: Int) {
        head?.let {
            if (head.next != null) {
                recurse(head.next, currentDepth + 1)
            } else {
                depth = currentDepth
            }
            if(currentDepth == depth / 2 + 1) result = head
        }
    }
}