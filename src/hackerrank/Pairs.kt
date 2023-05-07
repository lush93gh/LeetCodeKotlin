package hackerrank

class Pairs {
    fun pairs(k: Int, arr: Array<Int>): Int {
        // Write your code here
        val table = mutableMapOf<Int, Boolean>()
        arr.forEach {
            table[it] = true
        }
        var sum = 0
        arr.forEach {
            val find = it - k
            if (table.contains(find)) {
                sum++
            }
        }
        return sum
    }
}