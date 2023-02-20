package array

// 121. Best Time to Buy and Sell Stock
class E121 {
    fun maxProfit(prices: IntArray): Int {
        var valley = Int.MAX_VALUE
        var max = 0
        prices.forEach { price ->
            if (price < valley) {
                valley = price
            }
            if (price - valley > max) {
                max = price - valley
            }
        }
        return max
    }
}