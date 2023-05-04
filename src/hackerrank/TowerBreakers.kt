package hackerrank

class TowerBreakers {
    fun towerBreakers(n: Int, m: Int): Int {
        // Write your code here
        return if (m == 1 || n % 2 == 0) return 2
        else 1
    }
}