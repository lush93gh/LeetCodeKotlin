package linkedlist

import java.util.*

//  146. LRU Cache
class M146(private val capacity: Int) {
    private val deque: Queue<Int> = ArrayDeque<Int>(capacity)
    private val map = mutableMapOf<Int, Int>()
    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            deque.remove(key)
            deque.offer(key)
            map[key]!!
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map.replace(key, value)
            deque.remove(key)
            deque.offer(key)
        } else {
            if (deque.count() == capacity) {
                val removeKey = deque.poll()
                map.remove(removeKey)
            }
            if (deque.size < capacity) {
                map[key] = value
                deque.offer(key)
            }
        }
    }

}