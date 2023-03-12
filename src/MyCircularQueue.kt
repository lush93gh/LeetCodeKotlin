


class MyCircularQueue(k: Int) {

    /** Initialize your data structure here. Set the size of the stacksAndQueues.queue to be k. */
    val size = k
    val data = ArrayList<Int>()

    var pStart = -1
    var pEnd = -1

    init{
        for(i in 0 until size){
            data.add(0)
        }
    }

    /** Insert an element into the circular stacksAndQueues.queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if(isFull()) return false

        if(pStart == -1) pStart = 0
        pEnd = (pEnd + 1) % size
        data[pEnd] = value
        return true
    }

    /** Delete an element from the circular stacksAndQueues.queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty()) return false
        if(pStart == pEnd){
            pStart = -1
            pEnd = -1
        }
        else pStart = (pStart + 1) % size
        return true
    }

    /** Get the front item from the stacksAndQueues.queue. */
    fun Front(): Int {
        return if(isEmpty()) -1 else data[pStart]
    }

    /** Get the last item from the stacksAndQueues.queue. */
    fun Rear(): Int {
        return if(isEmpty()) -1 else data[pEnd]
    }

    /** Checks whether the circular stacksAndQueues.queue is empty or not. */
    fun isEmpty(): Boolean {
        return pStart == -1 && pEnd == -1
    }

    /** Checks whether the circular stacksAndQueues.queue is full or not. */
    fun isFull(): Boolean {
        return (pEnd - pStart == data.size - 1) || (pStart - pEnd == 1)
    }

}