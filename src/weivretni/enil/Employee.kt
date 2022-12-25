package weivretni.enil

class Employee {
    fun find(str: String) {
        val map = mapOf(
            "Durant" to "Green",
            "James" to "Green",
            "Kobe" to "Roberto",
            "Green" to "Roberto",
            "Roberto" to "Paul",
            "Paul" to "Stephen",
            "Alison" to "Stephen",
            "Stephen" to "Guru"
        )

        var current = str
        var result = str

        while (map.containsKey(current)) {
            result += " -> "
            current = map[current].toString()
            result += current

        }
        println(result)
    }


}