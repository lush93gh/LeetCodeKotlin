package weivretni.ta

class FixedPoint {
    // Time complexity: O(log(n))
    //Space complexity: O(1)
    fun fixedPoint(arr: IntArray): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val mid = low + high ushr 1

            val midVal: Int = arr[mid]

            if (midVal < mid) low = mid + 1
            else if (midVal > mid) high = mid - 1
            else return mid
        }
        return -1
    }
}