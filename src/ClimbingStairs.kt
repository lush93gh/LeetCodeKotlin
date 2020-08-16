class ClimbingStairs {
    lateinit var cache: HashMap<Int, Int>

    fun climbStairs(n: Int): Int {
        cache = HashMap<Int, Int>()
        return climb(n, 0)
    }

    fun climb(n: Int, steps: Int): Int{
        if(cache.containsKey(steps)) return cache[steps]!!

        if(n- steps == 1 || n==steps) return 1
        else if(steps > n) return 0

        val result = climb(n, steps + 1) + climb(n, steps +2)
        cache[steps] = result

        return result
    }
}