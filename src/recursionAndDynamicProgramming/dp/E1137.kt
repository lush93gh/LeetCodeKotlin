package recursionAndDynamicProgramming.dp

// 1137. N-th Tribonacci Number
class E1137 {
    fun tribonacci(n: Int): Int {
        var a = 0
        var b = 1
        var c = 1
        if (n == 0) return a
        if (n == 1) return b
        if (n == 2) return c
        var d = a + b + c
        for (i in 3..n) {
            d = a + b + c
            a = b
            b = c
            c = d
        }
        return d
    }
}