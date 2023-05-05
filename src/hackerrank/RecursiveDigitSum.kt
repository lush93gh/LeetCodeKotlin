package hackerrank

class RecursiveDigitSum {
    fun superDigit(n: String, k: Int): Int {
        // Write your code here
        var digit = stringToDigit(n)
        digit *= k

        return superDigit(digit).toInt()
    }

    private fun stringToDigit(n: String): Long {
        return if (n.isEmpty()) 0
        else (n.last() - '0') + stringToDigit(n.take(n.length - 1))
    }

    private fun superDigit(n: Long): Long {
        return if (n / 10L == 0L) n
        else {
            val digitSum = sumOfDigits(n)
            superDigit(digitSum)
        }
    }

    private fun sumOfDigits(n: Long): Long {
        return if (n == 0L) 0
        else n % 10 + superDigit(n / 10)
    }
}