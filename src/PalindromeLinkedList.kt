import kotlin.math.abs

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        head?.let{
            var root = head
            var number = root.`val`
            var power = 1

            while(root?.next != null){
                root = root.next
                power = power shl 1
                number += root?.`val`!! * power
            }

            var revertedNumber = 0

            number = abs(number)

            while(number > revertedNumber){
                revertedNumber = revertedNumber *2 + number%2
                number = number shr 1
            }

            return number == revertedNumber || number == (revertedNumber shr 2)
        }
        return true
    }
}