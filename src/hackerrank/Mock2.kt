package hackerrank

class FlippingTheMatrix {
    fun flippingMatrix(matrix: Array<Array<Int>>): Int {
        for (i in matrix.size / 2 until matrix.size) {
            var upperSum = 0
            var lowerSum = 0

            for (j in matrix.indices) {
                if (j < matrix.size / 2) upperSum += matrix[i][j]
                else lowerSum += matrix[i][j]
            }
            if (lowerSum < upperSum) {
                for (j in matrix.indices) {
                    matrix[i][j] = matrix[i][matrix.size - 1 - j]
                }
            }
        }

        for (i in matrix.size / 2 until matrix.size) {
            var upperSum = 0
            var lowerSum = 0

            for (j in matrix.indices) {
                if (j < matrix.size / 2) upperSum += matrix[j][i]
                else lowerSum += matrix[j][i]
            }
            if (upperSum < lowerSum) {
                for (j in matrix.indices) {
                    matrix[j][i] = matrix[matrix.size - 1 - j][i]
                }
            }
        }

        for (i in 0 until matrix.size / 2) {
            var upperSum = 0
            var lowerSum = 0

            for (j in matrix.indices) {
                if (j < matrix.size / 2) upperSum += matrix[i][j]
                else lowerSum += matrix[i][j]
            }
            if (upperSum < lowerSum) {
                for (j in matrix.indices) {
                    matrix[i][j] = matrix[i][matrix.size - 1 - j]
                }
            }
        }

        var sum = 0
        for (i in 0 until matrix.size / 2) {
            for (j in 0 until matrix.size / 2) {
                sum += matrix[i][j]
            }
        }

        return sum
    }
}