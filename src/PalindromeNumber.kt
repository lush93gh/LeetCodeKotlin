import kotlin.math.log10
import kotlin.math.roundToInt

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if(x< 0) return false

        var number = x
        val digits = mutableListOf<Int>()

        while(number > 0){
            digits.add(number%10)
            number /= 10
        }

        for(i in 0 until digits.size/2){
            if(digits[i] != digits[digits.size -1 -i])
                return false
        }

        return true
    }
}