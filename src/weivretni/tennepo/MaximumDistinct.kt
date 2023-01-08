package weivretni.tennepo

class MaximumDistinct {
    fun getMaximumDistinctCount(a: Array<Int>, b: Array<Int>, k: Int): Int {
        // Write your code here
        val map = mutableMapOf<Int, Int>()
        for (i in a.indices) {
            if (map.containsKey(a[i])) {
                map[a[i]] = map[a[i]]!! + 1
            } else {
                map[a[i]] = 1
            }
        }

        var duplications = a.size - map.count()
        var swap = k

        val mapB = mutableSetOf<Int>()

        b.forEachIndexed { index, num ->
            if(!map.containsKey(num)){
                mapB.add(num)
            }
        }

        val chances = mapB.count()
        

        return map.count()
    }
}