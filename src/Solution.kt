class Solution {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val newRow = IntArray(5)
            val nnr = IntArray(5)
            val board = arrayOf(newRow, nnr)

            val nextBoard = Array(board.size){i -> IntArray(board[i].size)}

            println(nextBoard.size)
            println(nextBoard[1][0])
        }
    }


}


