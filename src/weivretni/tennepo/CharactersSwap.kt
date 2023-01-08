package weivretni.tennepo

class CharactersSwap {
    fun getString(s: String): String {
        // Write your code here
        val ss = s.toCharArray().apply {
            sort()
        }
        return String(ss)
    }
}