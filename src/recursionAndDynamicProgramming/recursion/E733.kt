package recursionAndDynamicProgramming.recursion

import java.util.*

class E733 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val root = Pair(sr, sc)
        queue.add(root)
        visited.add(root)
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val node = queue.poll()
                val neighbors = findFlood(image, node.first, node.second, image[node.first][node.second])
                neighbors.forEach { neighbor ->
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor)
                        visited.add(neighbor)
                    }
                }
                image[node.first][node.second] = color
            }
        }
        return image
    }

    private fun findFlood(image: Array<IntArray>, sr: Int, sc: Int, color: Int): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        val up = sr - 1
        val down = sr + 1
        val left = sc - 1
        val right = sc + 1
        if (up >= 0 && image[up][sc] == color) {
            result.add(Pair(up, sc))
        }
        if (down < image.size && image[down][sc] == color) {
            result.add(Pair(down, sc))
        }
        if (left >= 0 && image[sr][left] == color) {
            result.add(Pair(sr, left))
        }
        if (right < image.first().size && image[sr][right] == color) {
            result.add(Pair(sr, right))
        }
        return result
    }
}