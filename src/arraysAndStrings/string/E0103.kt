package arraysAndStrings.string

class E0103 {
    fun replaceSpaces(S: String, length: Int): String {
        val sb = StringBuilder()
        for (i in 0 until length) {
            if (S[i] == ' ') {
                sb.append("%20")
            } else {
                sb.append(S[i])
            }
        }
        return sb.toString()
    }
}