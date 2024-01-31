package modreate

class E1275 {
    fun tictactoe(moves: Array<IntArray>): String {
        var flag = false
        val table = arrayOf(
            IntArray(3),
            IntArray(3),
            IntArray(3)
        )
        moves.forEach { move ->
            table[move[0]][move[1]] = if (flag) 1 else -1
            flag = !flag
        }

        var mainDiagonalSum = 0
        var counterDiagonalSum = 0
        for (i in table.indices) {
            val row = table[i]
            if (row.sum() == table.size) return "B"
            else if (row.sum() == -table.size) return "A"

            var colSum = 0
            for (j in table.indices) {
                colSum += table[j][i]
            }
            if (colSum == table.size) return "B"
            else if (colSum == -table.size) return "A"

            mainDiagonalSum += table[i][i]
            counterDiagonalSum += table[i][table.size - 1 - i]
        }
        if (mainDiagonalSum == table.size) return "B"
        else if (mainDiagonalSum == -table.size) return "A"

        if (counterDiagonalSum == table.size) return "B"
        else if (counterDiagonalSum == -table.size) return "A"

        table.forEach { row ->
            if (row.contains(0)) return "Pending"
        }

        return "Draw"
    }
}