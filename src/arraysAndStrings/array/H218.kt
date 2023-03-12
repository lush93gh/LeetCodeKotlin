package arraysAndStrings.array


class H218 {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        var maxIndex = 0
        buildings.forEach { building ->
            if (building[0] > maxIndex) maxIndex = building[0]
            if (building[1] > maxIndex) maxIndex = building[1]
        }

        val intArray = mutableMapOf<Int, List<Int>>()
        buildings.forEach { building ->
            val height = building[2]
            intArray[building[0]] = intArray.getOrDefault(building[0], listOf()).toMutableList().apply {
                add(height)
            }
            intArray[building[1]] = intArray.getOrDefault(building[1], listOf()).toMutableList().apply {
                add(-height)
            }
        }

        val result = mutableListOf<List<Int>>()
        var prevSet = mutableListOf<Int>()
        var height = 0

        intArray.toSortedMap().forEach { (index, set) ->
            val minus = set.filter { it < 0 }.map { -it }
            val plus = set.filter { it > 0 }
            val nextSet = if (index > 0) prevSet.apply {
                minus.forEach { remove(it) }
                addAll(plus)
            } else set
            val nextHeight = nextSet.max() ?: 0
            if (height != nextHeight) {
                result.add(listOf(index, nextHeight))
            }
            prevSet = nextSet.toMutableList()
            height = nextHeight
        }

        return result
    }
}