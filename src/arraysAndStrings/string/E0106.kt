package arraysAndStrings.string

class E0106 {
    fun compressString(S: String): String {
        if (S.isEmpty()) return S
        val sb = StringBuilder()
        var prevChar = S[0]
        var count = 0
        var totalLength = 0
        for (i in S.indices) {
            val char = S[i]
            if (char == prevChar) {
                count++
            } else {
                val appendString = "$prevChar$count"
                if (totalLength + appendString.length >= S.length) {
                    return S
                }
                sb.append(appendString)
                totalLength += appendString.length
                count = 1
            }
            prevChar = char
        }

        if (count > 0) {
            val appendString = "$prevChar$count"
            if (totalLength + appendString.length >= S.length) {
                return S
            }
            sb.append(appendString)
        }
        return sb.toString()
    }
}