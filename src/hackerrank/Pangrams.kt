package hackerrank

class Pangrams {
    fun pangrams(s: String): String {
        // Write your code here
        val characters = s.toLowerCase().filter { it in 'a'..'z' }.groupBy { it }.keys.size
        return if(characters == 26) "pangram" else "not pangram"
    }
}