package arraysAndStrings.string

class ToChineseString {
    fun toChineseString(input: Int): String {
        var output: String = ""
        var num: Int = input
        var u: Int = 1

        while (num > 0) {
            val numNod10 = num % 10

            val unitOutput = if(numNod10 == 0) ""+ output else  when (u) {
                10 -> "十" + output
                100 -> "百" + output
                1000 -> "千" + output
                10000 -> "萬" + output
                100000 -> "十" + output
                1000000 -> "百" + output
                10000000 -> "千" + output
                else -> ""
            }


            output = when (numNod10) {
                0 -> "零" + unitOutput
                1 -> "壹" + unitOutput
                2 -> "貳" + unitOutput
                3 -> "參" + unitOutput
                4 -> "肆" + unitOutput
                5 -> "伍" + unitOutput
                6 -> "陸" + unitOutput
                7 -> "柒" + unitOutput
                8 -> "捌" + unitOutput
                9 -> "玖" + unitOutput
                else ->  ""
            }



            num /= 10
            u *= 10
        }

        return output
    }
}