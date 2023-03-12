package arraysAndStrings.array

class M1943 {
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        var maxIndex = 0
        segments.forEach { segment ->
            if (segment[0] > maxIndex) maxIndex = segment[0]
            if (segment[1] > maxIndex) maxIndex = segment[1]
        }
        val longArray = Array<Set<Long>>(maxIndex + 1) { mutableSetOf() }
        segments.forEach { segment ->
            val color = segment[2].toLong()
            longArray[segment[0]] = longArray[segment[0]].toMutableSet().apply {
                add(color)
            }
            longArray[segment[1]] = longArray[segment[1]].toMutableSet().apply {
                add(-color)
            }
        }
        val ans = mutableListOf<List<Long>>()
        var color = 0L
        var left = longArray.indexOfFirst { it.sum() != 0L }
        var prevSet = longArray[left]
        longArray.forEachIndexed { index, set ->
            val nextColor = if (index > 0) set.sum() + color else set.sum()
            if (color != nextColor) {
                if (index.toLong() > left && color != 0L) {
                    ans.add(listOf(left.toLong(), index.toLong(), color))
                }
                left = index
            } else if (set != prevSet && set != setOf<Long>() && color != 0L) {
                ans.add(listOf(left.toLong(), index.toLong(), color))
                left = index
            }
            color = nextColor
        }

        return ans
    }
}