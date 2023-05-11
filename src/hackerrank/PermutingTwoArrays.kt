package hackerrank

class PermutingTwoArrays {
    fun twoArrays1(k: Int, A: Array<Int>, B: Array<Int>): String {
        // Write your code here
        return if (A.sum().toLong() + B.sum() < k.toLong() * A.size) "NO"
        else if (A.max()!!.toLong() + B.min()!!  < k.toLong() || B.max()!!.toLong() + A.min()!!  < k.toLong()) "NO"
        else "YES"
    }

    fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {
        // Write your code here
        A.sort()
        B.sortDescending()
        for(i in A.indices){
            if(A[i] + B[i] < k) return "NO"
        }
        return "YES"
    }

}