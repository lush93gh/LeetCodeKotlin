package hackerrank

class FlippingTheMatrix {
    fun flippingMatrix(matrix: Array<Array<Int>>): Int {
        var sum = 0
        for (i in 0 until matrix.size / 2) {
            for (j in 0 until matrix.size / 2) {
                val a = matrix[i][j]
                val b = matrix[i][matrix.size - 1 - j]
                val c = matrix[matrix.size - 1 - i][j]
                val d = matrix[matrix.size - 1 - i][matrix.size - 1 - j]
                sum += listOf(a, b, c, d).max()!!
            }
        }

        return sum
    }
}