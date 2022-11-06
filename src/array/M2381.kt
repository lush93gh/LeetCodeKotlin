package array

class M2381 {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val charArray = s.toCharArray()
        val intArray = IntArray(s.length + 1)
        shifts.forEach { shift ->
            val direction = if (shift[2] == 1) 1 else -1
            intArray[shift[0]] = intArray[shift[0]] + direction
            intArray[shift[1] + 1] = intArray[shift[1] + 1] - direction
        }
        var shift = 0
        for (index in charArray.indices) {
            shift = if (index > 0) intArray[index] + shift
            else intArray[index]
            if (shift != 0) {
                val modular = (charArray[index].toInt() + shift - 97) % 26
                charArray[index] = when {
                    modular > 0 -> (modular + 97).toChar()
                    modular < 0 -> (modular + 123).toChar()
                    else -> 'a'
                }
            }
        }

        return String(charArray)
    }
}

