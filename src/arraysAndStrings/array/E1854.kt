package arraysAndStrings.array

class E1854 {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        var ans = Int.MAX_VALUE

        logs.forEach {outter->
            var count = 0
            logs.forEach { inner ->
                if(isInTheInterval(outter[0], inner[0], inner[1]))
                    count++
            }
            if(count >= max){
                if(count > max)
                    ans = outter[0]
                else if(count == max && outter[0]<ans)
                    ans = outter[0]
                max = count
            }
            count = 0
            logs.forEach { inner ->
                if(isInTheInterval(outter[1] - 1, inner[0], inner[1]))
                    count++
            }
            if(count >= max){
                if(count > max)
                    ans = outter[1] -1
                else if(count == max && outter[1] -1<ans)
                    ans = outter[1] -1
                max = count

            }
        }
        return ans
    }

    fun isInTheInterval(num: Int, start: Int, end: Int) = num in start until end
}