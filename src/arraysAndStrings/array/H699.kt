package arraysAndStrings.array

import java.lang.Integer.max

class H699 {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val maxHeights = IntArray(positions.size)
        positions.forEachIndexed { index, position ->
            val left = position[0]
            val sideLength = position[1]
            val right = left + sideLength
            maxHeights[index] += sideLength

            for (i in index + 1 until positions.size) {
                val left2 = positions[i][0]
                val sideLength2 = positions[i][1]
                val right2 = left2 + sideLength2
                if (left < right2 && right > left2) {
                    maxHeights[i] = max(maxHeights[index], maxHeights[i])
                }
            }
        }

        val ans = mutableListOf<Int>()
        var maxHeight = 0
        maxHeights.forEach {
            maxHeight = max(maxHeight, it)
            ans.add(maxHeight)
        }

        return ans
    }
}