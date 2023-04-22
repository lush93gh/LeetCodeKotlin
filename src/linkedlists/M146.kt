package linkedlists

import java.util.*

//  146. LRU Cache
class M146(private val capacity: Int) {
    val deque: Deque<Int> = ArrayDeque<Int>(capacity)
    val map = mutableMapOf<Int, Int>()
    fun get(key: Int): Int {
        if (map.contains(key)) {
            deque.remove(key)
            deque.offer(key)
        }
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (map.contains(key)) {
            deque.remove(key)
        } else if (deque.size >= capacity) {
            val removeKey = deque.poll()
            map.remove(removeKey)
        }

        deque.offer(key)
        map[key] = value
    }

}