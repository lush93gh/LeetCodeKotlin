package array

class E307 (nums: IntArray) {
    val array = nums.toMutableList()
    fun update(index: Int, `val`: Int) {
        array[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        for (i in left..right) {
            sum += array[i]
        }
        return sum
    }

}