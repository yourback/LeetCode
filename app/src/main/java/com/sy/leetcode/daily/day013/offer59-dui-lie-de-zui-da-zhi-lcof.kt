package com.sy.leetcode.daily.day013

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/31-9:30
 * @Email 609188080@qq.com
 */


// force
class MaxQueue() {

    private val intArray = IntArray(Int.MAX_VALUE)
    private var startIndex = 0
    private var endIndex = 0

    // O(n)
    fun max_value(): Int {
        return if (isEmpty()) -1
        else {
            var max = 0
            for (i in startIndex until endIndex) {
                max = Math.max(max, intArray[i])
            }
            max
        }
    }

    fun isEmpty(): Boolean {
        return startIndex == endIndex
    }

    fun push_back(value: Int) {
        intArray[endIndex++] = value
    }

    fun pop_front(): Int {
        return if (isEmpty()) -1
        else {
            intArray[startIndex++]
        }
    }
}



// queue use offer and poll
// stack use push and pop
class MaxQueue1() {

    val q = LinkedList<Int>()
    val d = LinkedList<Int>()

    fun max_value(): Int {
        return if (d.isEmpty()) -1
        else
            d.peekFirst()!!
    }


    fun push_back(value: Int) {
        while (d.isNotEmpty() && value > d.peekLast()!!) {
            d.pollLast()
        }
        d.offer(value)
        q.offer(value)
    }

    fun pop_front(): Int {
        return if (q.isEmpty()) -1
        else {
            if (q.first == d.first) {
                d.pollFirst()
            }
            q.pollFirst()!!
        }
    }
}
