package arraysAndStrings.string

class E796 {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        goal.forEachIndexed { index, c ->
            if (c == s[0]) {
                var j = index
                var hasFailed = false
                s.forEach {
                    if (it != goal[j]) {
                        hasFailed = true
                        return@forEach
                    }
                    j = (j + 1) % goal.length
                }
                if (!hasFailed) return true
            }
        }
        return false
    }
}