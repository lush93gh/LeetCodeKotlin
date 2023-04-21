package arraysAndStrings.string

class E67 {
    fun addBinary(a: String, b: String): String {
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0
        var result = ""
        while (i >= 0 || j >= 0 || carry > 0) {
            val x = if (i >= 0) a[i] - '0' else 0
            val y = if (j >= 0) b[j] - '0' else 0
            val sum = x + y + carry
            carry = sum / 2
            val bit = sum % 2
            result = "$bit" + result
            i--
            j--
        }

        return result
    }
}