class Solution {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val pl = PalindromeLinkedList()
            val listNode = ListNode(-129)
            listNode.next = ListNode(-129)
            pl.isPalindrome(listNode)
        }
    }
}