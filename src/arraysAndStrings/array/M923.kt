package arraysAndStrings.array

// 923. 3Sum With Multiplicity
class M923 {
    private val mod = 1_000_000_007
    fun threeSumMulti1(arr: IntArray, target: Int): Int {
        arr.sort()
        var ans = 0L
        for (i in 0 until arr.size - 2) {
            val num = arr[i]
            val twoSumTarget = target - num
            var j = i + 1
            var k = arr.size - 1
            while (j < k) {
                val twoSum = arr[j] + arr[k]
                if (twoSum < twoSumTarget) j++
                else if (twoSum > twoSumTarget) k--
                else {
                    if (arr[j] == arr[k]) {
                        val m = k - j + 1
                        ans = (ans + m * (m - 1) / 2) % mod
                        break
                    } else {
                        var jCount = 1
                        var kCount = 1
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            jCount++
                            j++
                        }
                        while (j < k - 1 && arr[k] == arr[k - 1]) {
                            kCount++
                            k--
                        }
                        ans = (ans + jCount * kCount) % mod
                        j++
                        k--
                    }
                }
            }
        }
        return ans.toInt()
    }

    fun threeSumMulti2(arr: IntArray, target: Int): Int {
        var ans = 0L
        val count = IntArray(101) { 0 }
        arr.forEach {
            count[it]++
        }

        for (x in count.indices) {
            for (y in x + 1 until count.size) {
                val z = target - x - y
                if (z in (y + 1)..100) {
                    val sum = count[x].toLong() * count[y] * count[z]
                    ans = (sum + ans) % mod
                }
            }
        }

        for (x in count.indices) {
            val z = target - 2 * x
            if (z in (x + 1)..100) {
                val sum = count[x].toLong() * (count[x] - 1) / 2 * count[z]
                ans = (sum + ans) % mod
            }
        }

        for (x in count.indices) {
            // target and x will either both be odd numbers or both be even numbers
            if (target % 2 == x % 2) {
                val z = (target - x) / 2
                if (z in (x + 1)..100) {
                    val sum = count[x].toLong() * count[z] * (count[z] - 1) / 2
                    ans = (sum + ans) % mod
                }
            }
        }

        if (target % 3 == 0) {
            for (x in count.indices) {
                // target will be a number multiplied by 3
                if (x * 3 == target) {
                    val sum = (count[x].toLong() * (count[x] - 1) * (count[x] - 2) / 6 % mod)
                    ans = (sum + ans) % mod
                    break
                }
            }
        }

        return ans.toInt()
    }

    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val counts = LongArray(101) { 0 }
        arr.sort()
        val nums = mutableListOf<Int>()
        arr.forEach {
            counts[it]++
            if (counts[it] == 1L) {
                nums.add(it)
            }
        }

        var ans = 0L
        for (i in nums.indices) {
            val num = nums[i]
            var twoSumTarget = target - num
            var j = i
            var k = nums.size - 1
            while (j <= k) {
                val twoSum = nums[j] + nums[k]
                if (twoSum < twoSumTarget) j++
                else if (twoSum > twoSumTarget) k--
                else {
                    if (j in (i + 1) until k) {
                        ans += counts[nums[i]] * counts[nums[j]] * counts[nums[k]]
                    } else if (i == j && j < k) {
                        ans += counts[nums[i]] * (counts[nums[i]] - 1) / 2 * counts[nums[k]]
                    } else if (i < j && j == k) {
                        ans += counts[nums[i]] * counts[nums[j]] * (counts[nums[j]] - 1) / 2
                    } else if (i == j && j == k) {
                        ans += counts[nums[i]] * (counts[nums[i]] - 1) * (counts[nums[i]] - 2) / 6
                    }
                    ans %= mod
                    j++
                    k--
                }
            }
        }

        return ans.toInt()
    }

//    private fun twoSum(arr: List<Int>, target: Int, i: Int, j: Int) {
//        if (i < j) {
//            val sum = arr[i] + arr[j]
//            if (sum < target) twoSum(arr, target, i + 1, j)
//            else if (sum > target) twoSum(arr, target, i, j - 1)
//            else {
//                twoSumNumbers.add(setOf(arr[i], arr[j]))
//                twoSum(arr, target, i + 1, j - 1)
//            }
//        }
//    }
//
//    private fun c(m: Int, n: Int): Long {
//        val mf = factorial(m) % (10.0.pow(9) + 7).toLong()
//        val nf = factorial(n) % (10.0.pow(9) + 7).toLong()
//        val mnf = factorial(m - n) % (10.0.pow(9) + 7).toLong()
//        return mf.div(nf.times(mnf) % (10.0.pow(9) + 7).toLong())
//    }
//
//    private val factorialTable = mutableMapOf<Int, Long>().apply {
//        this[1] = 1
//    }
//
//    private fun factorial(n: Int): Long {
//        return if (n == 1) 1
//        else if (factorialTable.contains(n)) factorialTable[n]!!
//        else {
//            val result = n * (factorial(n - 1) % (10.0.pow(9) + 7).toLong())
//            factorialTable[n] = result
//            result
//        }
//    }
}