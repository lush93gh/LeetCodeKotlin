class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val regex = """([a-z0-9])""".toRegex()
        val result = regex.findAll(s.toLowerCase())
        val array = mutableListOf<MatchResult>()
        array.addAll(result)

        for(i in 0 until array.size/ 2){
            if(array[i].value != array[array.size -1 - i].value)
                return false
        }

        return true
    }
}