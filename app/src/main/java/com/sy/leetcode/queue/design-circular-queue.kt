package com.sy.leetcode.queue

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/22-15:56
 * @Email 609188080@qq.com
 */

// ☆

// 622. 设计循环队列
// https://leetcode-cn.com/problems/design-circular-queue/

class MyCircularQueue(k: Int) {

    private val array = IntArray(k + 1)
    private var head = 0
    private var tail = 0


    fun enQueue(value: Int): Boolean {
        return if (isFull()) false
        else {
            array[tail] = value
            tail = tailPlusOne()
            true
        }
    }

    fun deQueue(): Boolean {
        return if (isEmpty()) false
        else {
            head = headPlusOne()
            true
        }
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        else return array[head]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1
        else array[tailMinusOne()]
    }

    fun isEmpty(): Boolean {
        return head == tail
    }

    fun isFull(): Boolean {
        return tailPlusOne() == head
    }

    private fun tailMinusOne(): Int {
        return if (tail > 0) tail - 1
        else array.size - 1
    }

    private fun tailPlusOne(): Int {
        return (tail + 1) % array.size
    }

    private fun headPlusOne(): Int {
        return (head + 1) % array.size
    }
}

fun main() {
    val obj = MyCircularQueue(3)
    obj.enQueue(1).print()
    obj.enQueue(2).print()
    obj.enQueue(3).print()
    obj.enQueue(4).print() // false
    obj.Rear().print()
    obj.isFull().print()
    obj.deQueue().print()
    obj.enQueue(4).print()
    obj.Rear().print()
}