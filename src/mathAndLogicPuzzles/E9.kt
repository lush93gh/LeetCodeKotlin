package mathAndLogicPuzzles

class E9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        else {
            val list = mutableListOf<Int>()
            var y = x
            while (y > 0) {
                list.add(y % 10)
                y /= 10
            }
            list.forEachIndexed { index, num ->
                if (num != list[list.size - 1 - index]) return false
            }
            return true
        }
    }

    fun isPalindrome2(x: Int): Boolean {
        if (x < 0 || x % 10 == 0 && x != 0) return false

        var number = x
        var revertedNumber = 0

        while (number > revertedNumber) {
            revertedNumber = revertedNumber * 10 + number % 10
            number /= 10
        }

        return number == revertedNumber || number == revertedNumber / 10
    }
}