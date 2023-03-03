package array

class M167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        var j = 0
        var k = numbers.size - 1
        while (j < k) {
            val sum = numbers[j] + numbers[k]
            if (sum == target) {
                result[0] = j + 1
                result[1] = k + 1
                break
            } else if (sum < target) {
                j++
            } else {
                k--
            }
        }
        return result
    }
}