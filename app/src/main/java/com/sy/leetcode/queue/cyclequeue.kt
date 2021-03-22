package com.sy.leetcode.queue

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/22-11:35
 * @Email 609188080@qq.com
 */
// cycle queue
class CycleQueue(capacity: Int) {
    private val array = IntArray(capacity + 1)
    private var head: Int = 0
    private var tail: Int = 0

    fun enqueue(x: Int): Boolean {
        return if (isFull()) false
        else {
            array[tail] = x
            tail = tailPlusOne()
            true
        }
    }

    fun dequeue(): Int? {
        return if (isEmpty()) null
        else {
            val ret = array[headPlusOne()]
            head = headPlusOne()
            ret
        }
    }

    private fun isFull(): Boolean {
        return tailPlusOne() == head
    }

    private fun tailPlusOne(): Int {
        return (tail + 1) % array.size
    }

    private fun headPlusOne(): Int {
        return (head + 1) % array.size
    }


    fun isEmpty(): Boolean {
        return head == tail
    }
}

fun main() {
    val lq = CycleQueue(5)
    lq.enqueue(1).print()
    lq.enqueue(2).print()
    lq.enqueue(3).print()
    lq.enqueue(4).print()
    lq.enqueue(5).print()
    lq.enqueue(6).print()

    lq.isEmpty().print()
    lq.dequeue().print()
    lq.enqueue(6)

    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()


    lq.enqueue(6)
    lq.enqueue(6)
    lq.enqueue(6)
    lq.enqueue(6)
    lq.enqueue(6)

    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()

}