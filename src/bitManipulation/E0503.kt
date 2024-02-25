package bitManipulation

import kotlin.math.pow

class E0503 {
    fun reverseBits(num: Int): Int {
        val normalizedNum = (if (num >= 0) num.toLong() else (2.0.pow(32) + num).toLong()).toString(2)
        val split = normalizedNum.split("0")
        var max = Int.MIN_VALUE
        for (i in split.indices) {
            var length = split[i].length
            if (i + 1 < split.size) {
                length += split[i + 1].length
            }
            if (length > max) {
                max = length
            }
        }
        return if(normalizedNum.length < 32 || normalizedNum.contains("0")) max + 1 else max
    }
}