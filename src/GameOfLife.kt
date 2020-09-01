class GameOfLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        for(i in board.indices){
            for(j in board[i].indices){
                var count = 0
                for(k in -1..1){
                    for(l in -1..1){
                        if(k == 0 && l ==0) continue
                        val ri = i + k
                        val ci = j + l
                        if(ri >= 0 && ri < board.size &&
                                ci>= 0 && ci < board[i].size){
                            val value = board[ri][ci]
                            count += if(value == -1) 1 else if(value == 2) 0 else value
                        }
                    }
                }

                if(board[i][j] == 1){
                    if(count < 2 || count > 3) board[i][j] = -1
                }
                else{
                     if(count == 3) board[i][j] = 2
                 }
            }
        }

        for(i in board.indices){
            for(j in board[i].indices){
                val value = board[i][j]
                board[i][j] = if(value == -1) 0 else if(value == 2) 1 else value
            }
        }
    }
}