package linkedlists

import ListNode

class M382(head: ListNode?) {
    val seed = 1_0000
    val HEAD = head
    var pointer = head
    fun getRandom(): Int {
        val bound = (1..seed).random()
        for (i in 1..bound) {
            if (pointer == null) {
                pointer = HEAD
            }
            pointer = pointer!!.next
        }
        if (pointer == null) {
            pointer = HEAD
        }
        return pointer!!.`val`
    }
}