class GameOfLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val nextBoard = Array(board.size){i -> IntArray(board[i].size)}

        for(i in board.indices){
            val newRow = IntArray(board[i].size)
            for(j in board[i].indices){
                var count = 0
                for(k in -1..1){
                    for(l in -1..1){
                        if(k == 0 && l ==0) continue
                        val ri = i + k
                        val ci = j + l
                        if(ri >= 0 && ri < board.size &&
                                ci>= 0 && ci < board[i].size){
                            count += board[ri][ci]
                        }
                    }
                }

                if(board[i][j] == 1){
                     newRow[j] = when (count) {
                         2, 3 -> 1
                         else -> 0
                     }
                }
                else{
                    newRow[j] = if(count == 3) 1 else 0
                 }
            }
            nextBoard[i] = newRow
        }

        for(i in board.indices){
            for(j in board[i].indices){
                board[i][j] = nextBoard[i][j]
            }
        }
    }
}