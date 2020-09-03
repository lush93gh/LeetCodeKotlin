class GameOfLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val map = HashMap<Int, Int>()
        for(i in board.indices){
            for(j in board[i].indices){
                if(board[i][j] == 1){
                    for(k in -1..1){
                        for(l in -1..1){
                            val ri = i + k
                            val ci = j + l
                            if(ri >= 0 && ri < board.size &&
                                ci>= 0 && ci < board[i].size){
                                val value = ri * board[ri].size + ci

                                if(!map.containsKey(value)) map[value] = 0
                                if(k != 0 || l !=0) map[value] = map[value]!! + 1
                            }
                        }
                    }
                }
            }
        }

        for(cell in map){
            val i = cell.key / board[0].size
            val j = cell.key % board[0].size
            val count = cell.value
            board[i][j] = if(count == 3 ||(count == 2 && board[i][j] == 1)) 1 else 0
        }
    }
}