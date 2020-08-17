class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val map = HashMap<Char, Int>()
        var count = 0

        for(c in s){
            if(!map.containsKey(c)) map[c] = 0
            val cCount = map[c]!!

            if(cCount == 0) map[c] = 1
            else if(cCount == 1){
                count+=2
                map[c] = 0
            }
        }

        for(c in s){
            val cCount = map[c]!!
            if(cCount == 1){
                count++
                break
            }
        }

        return count
    }
}