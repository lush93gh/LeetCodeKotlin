package hackerrank

class CaesarCipher {
    fun caesarCipher(s: String, k: Int): String {
        // Write your code here
        var result = ""
        s.forEach { c ->
            if (c in 'a'..'z') {
                result += (((c - 'a') + k) % 26 + 'a'.toInt()).toChar()
            } else if (c in 'A'..'Z') {
                result += (((c - 'A') + k) % 26 + 'A'.toInt()).toChar()
            } else {
                result += c
            }
        }
        return result
    }
}