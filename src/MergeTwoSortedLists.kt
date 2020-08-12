class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val L = IntArray(m + 1)
        for (i in 0 until m)
            L[i] = nums1[i]
        L[m] = Int.MAX_VALUE

        val R = IntArray(n + 1)
        for (i in 0 until n)
            R[i] = nums2[i]
        R[n] = Int.MAX_VALUE

        var i = 0
        var j = 0

        for (k in 0 until m + n) {
            if (L[i] <= R[j]) {
                nums1[k] = L[i]
                i++
            } else {
                nums1[k] = R[j]
                j++
            }
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

