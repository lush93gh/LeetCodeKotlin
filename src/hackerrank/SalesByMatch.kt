package hackerrank

class SalesByMatch {
    fun sockMerchant(n: Int, ar: Array<Int>): Int {
        // Write your code here
        var pairs = 0
        ar.groupBy { it }.forEach {
            pairs += it.value.size / 2
        }
        return pairs
    }
}