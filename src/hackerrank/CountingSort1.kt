package hackerrank

class CountingSort1 {
    fun countingSort(arr: Array<Int>): Array<Int> {
        // Write your code here
        val freq = Array(100) { 0 }
        arr.forEach {
            freq[it]++
        }
        return freq
    }
}