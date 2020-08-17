import kotlin.math.log10
import kotlin.math.roundToInt

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if(x< 0 || x%10 == 0 && x!=0) return false

        var number = x
        var revertedNumber = 0

        while(number > revertedNumber){
            revertedNumber = revertedNumber * 10 + number%10
            number /= 10
        }

        return number == revertedNumber || number == revertedNumber/10
    }
}