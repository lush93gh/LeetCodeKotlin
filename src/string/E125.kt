package string

class E125 {
    fun isPalindrome(s: String): Boolean {
        val regex = Regex("[^A-Za-z0-9]")
        val ans = regex.replace(s, "").toLowerCase()

        for (index in 0 until ans.length / 2) {
            if (ans[index] != ans[ans.length - 1 - index]) return false
        }
        return true
    }

    fun isPalindrome2(s: String): Boolean {
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