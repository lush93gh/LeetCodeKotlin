package hackerrank

class FindTheMedian {
    fun findMedian(arr: Array<Int>): Int {
        // Write your code here
        arr.sort()
        return arr[arr.size/2]
    }
}