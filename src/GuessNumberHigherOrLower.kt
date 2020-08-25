class GuessNumberHigherOrLower {
    fun guessNumber(n:Int):Int {
        var pivot: Int
        var left = 1
        var right = n

        while(left <= right){
            pivot = left + (right - left) /2
            when {
                0 == guess(pivot) -> return pivot
                -1 == guess(pivot) ->
                    right = pivot - 1
                1 == guess(pivot) ->
                    left = pivot +1
            }
        }
        return -1
    }

    fun guess(num:Int):Int {
        return 0
    }
}