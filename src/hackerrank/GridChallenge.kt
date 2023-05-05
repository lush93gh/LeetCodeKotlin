package hackerrank

class GridChallenge {
    fun gridChallenge(grid: Array<String>): String {
        val matrix = grid.map {
            it.toCharArray().apply {
                sort()
            }
        }

        val strlen = grid[0].length
        for (j in 0 until strlen) {
            for (i in 1 until matrix.size) {
                if (matrix[i - 1][j] > matrix[i][j]) {
                    return "NO"
                }
            }
        }
        return "YES"
    }
}