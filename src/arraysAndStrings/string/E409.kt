package arraysAndStrings.string

class E409 {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        s.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        var count = 0
        map.forEach { entry ->
            val value = entry.value / 2
            count += value * 2
            if (count % 2 == 0 && entry.value % 2 == 1) {
                count++
            }
        }
        return count
    }

    fun longestPalindrome2020(s: String): Int {
        val map = HashMap<Char, Int>()
        var count = 0

        for(c in s){
            if(!map.containsKey(c)) map[c] = 0
            val cCount = map[c]!!

            if(cCount == 0) map[c] = 1
            else if(cCount == 1){
                count += 2
                map[c] = 0
            }
        }

        return if(count < s.length) count + 1 else count
    }
}