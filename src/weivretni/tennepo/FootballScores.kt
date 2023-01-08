package weivretni.tennepo

import kotlin.math.abs

class FootballScores {
    fun counts(teamA: IntArray, teamB: IntArray): IntArray {
        teamA.sort()
        val result = IntArray(teamB.size)
        teamB.forEachIndexed { index, score ->
            result[index] = abs(teamA.binarySearch(score) + 1)
        }
        return result
    }
}