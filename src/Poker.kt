class Poker {
    val list = (1..52).toMutableList()
    fun draw(): String {
        val card = list.random()
        list.remove(card)
        val point = when (card % 4) {
            0 -> "黑桃"
            1 -> "梅花"
            2 -> "方塊"
            else -> "紅心"
        }
        val number = when (card % 13) {
            0 -> "A"
            10 -> "J"
            11 -> "Q"
            12 -> "K"
            else -> "${card % 13}"
        }
        return point + number
    }
}