package hackerrank

class TruckTour {
    fun truckTour(petrolpumps: Array<Array<Int>>): Int {
        // Write your code here
        val netPetrol = petrolpumps.map {
            it[0] - it[1]
        }

        for (i in netPetrol.indices) {
            val net = netPetrol[i]
            var sum = net
            var j = (i + 1) % netPetrol.size
            while (sum > 0 && j % netPetrol.size != 0) {
                sum += netPetrol[j]
                j = (j + 1) % netPetrol.size
            }
            if (j % netPetrol.size == 0) {
                return i
            }
        }
        return 0
    }
}