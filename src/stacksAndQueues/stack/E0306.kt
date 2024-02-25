package stacksAndQueues.stack

import java.util.*

class E0306 {
    private val anyQueue = LinkedList<IntArray>()
    private val dogQueue =  LinkedList<IntArray>()
    private val catQueue = LinkedList<IntArray>()

    fun enqueue(animal: IntArray) {
        anyQueue.add(animal)
        if (animal[1] == 0) {
            catQueue.add(animal)
        } else if (animal[1] == 1) {
            dogQueue.add(animal)
        }
    }

    fun dequeueAny(): IntArray {
        return if (anyQueue.isNotEmpty()) {
            val animal = anyQueue.removeFirst()
            if (animal[1] == 0) {
                catQueue.removeFirst()
            } else if (animal[1] == 1) {
                dogQueue.removeFirst()
            }
            animal
        } else {
            intArrayOf(-1, -1)
        }
    }

    fun dequeueDog(): IntArray {
        return if (dogQueue.isNotEmpty()) {
            val animal = dogQueue.removeFirst()
            anyQueue.remove(animal)
            animal
        } else {
            intArrayOf(-1, -1)
        }
    }

    fun dequeueCat(): IntArray {
        return if (catQueue.isNotEmpty()) {
            val animal = catQueue.removeFirst()
            anyQueue.remove(animal)
            animal
        } else {
            intArrayOf(-1, -1)
        }
    }
}