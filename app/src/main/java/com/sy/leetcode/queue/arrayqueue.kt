package com.sy.leetcode.queue

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/22-10:44
 * @Email 609188080@qq.com
 */

// array queue
class ArrayQueue(private val capacity: Int) {
    private val array = IntArray(capacity)
    private var head = 0
    private var tail = 0

    val size get() = tail - head

    fun enqueue(x: Int): Boolean {
        return if (size == capacity) false
        else {
            if (tail == capacity && head != 0) {
                for (i in 0 until size) {
                    array[i] = array[head + i]
                }
                head = 0
                tail = size - 1
            }
            array[tail] = x
            tail++
            true
        }
    }

    fun dequeue(): Int? {
        return if (isEmpty()) null
        else {
            array[head++]
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }
}

fun main() {
    val lq = ArrayQueue(5)
    lq.enqueue(1)
    lq.enqueue(2)
    lq.enqueue(3)
    lq.enqueue(4)
    lq.enqueue(5)

    lq.isEmpty().print()
    lq.size.print()
    lq.dequeue().print()
    lq.enqueue(6)

    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
}