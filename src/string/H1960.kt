package string

class H1960 {

    var list = mutableListOf<Pair<Int, Int>>()
    var max: Long = Long.MIN_VALUE
    fun maxProduct(s: String): Long {
        list = mutableListOf()
        max = Long.MIN_VALUE
        find(s)
        //  extend(s, 0)
        for (i in list.indices) {
            val (a, b) = list[i]
            for (j in i + 1 until list.size) {
                val (c, d) = list[j]
                if (c > b || a > d) {
                    //                print(s.substring(a, b + 1))
                    //                  print(" ")
                    //                   print(s.substring(c, d + 1))
                    val len: Long = (d.toLong() - c + 1) * (b - a + 1)
//                    print(" ")
//                    println(len.toString())
                    if (len > max) {
                        max = len
                    }
                } else {
                    val distance = (j - i + 1).toLong()
                    val half = distance / 2
                    val d1 = d.toLong() - c + 1
                    val d2 = b.toLong() - a + 1
                    val r1 = d1 / 2 + 1
                    val r2 = d2 / 2 + 1
                    var len: Long = Long.MIN_VALUE
                    if (r1 < half && r2 < half) {
                        len = d1 * d2
                    } else if (r1 < half && r2 >= half) {
                        len = d1 * (2 * (distance - r1 - 1) + 1)
                    } else if (r1 >= half && r2 < half) {
                        len = d2 * (2 * (distance - r1 - 1) + 1)
                    } else {
                        len = (2 * (half - 1) + 1) * (2 * (distance - half - 1) + 1)
                    }

                    if (len > max) {
                        max = len
                    }
                }
            }
        }
        return max
    }

    fun find(s: String) {
        for (i in s.indices) {
            extend(s, i)
        }
    }

    fun extend(s: String, p1: Int) {
        var i = p1
        var j = p1
        var found = false
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            found = true
            i--
            j++
        }
        if (found) {
//            print(p1)
//            println(s.substring(i + 1, j - 1 + 1))
            list.add(i + 1 to j - 1)
        }
    }
}