package recursion

import kotlin.math.abs

class Pow {
    fun myPow(x: Double, n: Int): Double {
        var power = abs(n.toLong())
        var result = 1.0
        var temp = x

        while(power>0){
            if(power % 2L == 1L)
                result *= temp

            temp *= temp
            power = power shr 1
        }

        return if(n>=0) result else 1.0/result
    }
}