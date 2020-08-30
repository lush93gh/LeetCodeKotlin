class FirstBadVersion {
    fun firstBadVersion(n: Int) : Int {
        var pivot: Long
        var left = 1L
        var right = n.toLong() + 1L
        var isBadVersion: Boolean

        while(left < right){
            pivot = left + (right - left) / 2
            isBadVersion = isBadVersion(pivot.toInt())
            when {
                isBadVersion -> right = pivot
                else -> left = pivot + 1
            }
        }

        return if(left != (n.toLong() + 1L) && isBadVersion(left.toInt())) left.toInt() else -1
    }

    private fun isBadVersion(version: Int) : Boolean{
        return version > 0
    }
}