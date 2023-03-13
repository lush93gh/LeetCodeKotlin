package arraysAndStrings.string

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        for(i in 0 until  s.size/2){
            val temp = s[i]
            s[i] = s[s.size -1 - i]
            s[s.size -1 - i] = temp
        }
    }
}