package arraysAndStrings.array

class E217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        nums.forEach {
            if (set.contains(it)) return true
            else {
                set.add(it)
            }
        }
        return false
    }
}