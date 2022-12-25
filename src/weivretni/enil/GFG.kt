package weivretni.enil

class GFG {
    fun encoding(str: String) {
        val length = str.length
        var i = 0
        var result = ""
        while (i < length) {
            var count = 1
            while (i < length - 1 && str[i] == str[i + 1]) {
                count++
                i++
            }

            // Print character and its count
            result += str[i].toString() + count
            i++
        }
        println(result)
    }
}