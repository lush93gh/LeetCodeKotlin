class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for(i in nums.indices){
            val b = target - nums[i]
            if(map.containsKey(b))
                return intArrayOf(i, map[b]!!)

            map[nums[i]] = i
        }

        return intArrayOf(0, 0)
    }
}