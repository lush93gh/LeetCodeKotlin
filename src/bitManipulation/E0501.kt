package bitManipulation

import kotlin.math.pow

class E0501 {
    fun insertBits(N: Int, M: Int, i: Int, j: Int): Int {
        val upper = (N shr (j + 1).coerceAtMost(31)) shl (j + 1)
        val lower = N and (2.0.pow(i) - 1).toInt()
        val mShiftedBits = (M shl i)
        return upper + lower + mShiftedBits
    }
}