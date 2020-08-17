class ValidPalindromeII {
    fun validPalindrome(s: String): Boolean {
        var toRemove = 0
        var result1 = true
        var result2 = true

        for(i in 0 until s.length/ 2){
            if(toRemove==0 && s[i] != s[s.length -1 - i])
                toRemove = 1
            if(result1 && toRemove ==1 && s[i+ toRemove] != s[s.length -1 - i])
                result1 = false
            if(result2 && toRemove ==1 && s[i] != s[s.length -1 - i - toRemove])
                result2 = false
        }

        return result1 || result2
    }
}