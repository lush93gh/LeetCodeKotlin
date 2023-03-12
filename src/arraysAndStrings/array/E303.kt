package arraysAndStrings.array

class E303(nums: IntArray) {
    private val array =  nums
    fun sumRange(left: Int, right: Int): Int {
        return array.sliceArray(left..right).sum()
    }

}