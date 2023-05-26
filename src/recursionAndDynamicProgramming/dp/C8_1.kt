package recursionAndDynamicProgramming.dp

class C8_1 {
    fun step(n: Int): Int {
        var a = 1
        var b = 2
        var c = 4
        if (n == 1) return a
        if (n == 2) return b
        if (n == 3) return c
        var d = a + b + c
        for (i in 4..n) {
            d = a + b + c
            a = b
            b = c
            c = d
        }
        return d
    }
}