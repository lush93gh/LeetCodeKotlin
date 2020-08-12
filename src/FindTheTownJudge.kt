class FindTheTownJudge {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val board = IntArray(N+1)
        for(t in trust){
            board[t[0]] -= 1
            board[t[1]] += 1
        }

        for(i in 1..N){
            if(board[i] == N - 1) return i
        }

        return -1
    }

    fun findJudgeMyWA(N: Int, trust: Array<IntArray>): Int {
        val board = LongArray(N)
        for(t in trust){
            board[t[0]-1] += (1L shl t[1]-1)
        }

        var count =0
        var result = 0

        for(i in board.indices){
            if(board[i] == 0L){
                var hasPassed = true
                val key = (1L shl i)
                for(j in board.indices){
                    if(j==i) continue
                    if((board[j] and key) != key){
                        hasPassed = false
                        break
                    }
                }
                if(hasPassed){
                    count++
                    result = i + 1
                }
            }
        }

        if(count==1) return result

        return -1
    }
}