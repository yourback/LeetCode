package com.sy.leetcode.day003

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/16-17:12
 * @Email 609188080@qq.com
 */
// linked stack


// array stack
class ArrayStack() {
    private var capacity: Int = 1

    constructor(capacity: Int) : this() {
        this.capacity = capacity
        ArrayStack()
    }

    private var array = arrayOfNulls<String>(capacity)
    var size = 0


    fun push(string: String) {
        if (size == capacity) {
            "扩容".print()
            // 1.5 capacity
            capacityGray()
        }
        array[size++] = string
    }

    private fun capacityGray() {
        capacity = capacity shl 2
        val temp = arrayOfNulls<String>(capacity)
        for (i in 0 until size) {
            temp[i] = array[i]
        }
        array = temp
        "扩容完成${array.size}".print()
    }

    fun pop(): String? {
        if (size == 0) {
            throw EmptyStackException()
        }
        return array[--size]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun peek(): String? {
        if (isEmpty()) return null
        return array[size - 1]
    }
}

fun main() {
    val s = ArrayStack()
    s.push("1")
    s.push("1")
    s.push("1")
    s.push("1")
    s.push("1")
    s.push("1")
    s.push("11")
    s.peek().print()
}

fun <T> T.print() {
    println(this.toString())
}