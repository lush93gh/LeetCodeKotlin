package recursionAndDynamicProgramming.recursion

import ListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var L = l1
        var R = l2

        var result : ListNode? = null

        if((L!= null && R!= null && (L.`val`<= R.`val`)) || (L != null && R == null)){
            result = ListNode(L.`val`)
            L = L.next
        }
        else if((L!= null && R!= null && (L.`val`> R.`val`)) || (L == null && R != null)){
            result = ListNode(R.`val`)
            R = R.next
        }

        var current = result

        while(L!= null || R!= null){
            if((L!= null && R!= null && (L.`val`<= R.`val`)) || (L != null && R == null)){
                current?.next = ListNode(L.`val`)
                current = current?.next
                L = L.next
            }
            else if((L!= null && R!= null && (L.`val`> R.`val`)) || (L == null && R != null)){
                current?.next = ListNode(R.`val`)
                current = current?.next
                R = R.next
            }
        }

        return result
    }
}

