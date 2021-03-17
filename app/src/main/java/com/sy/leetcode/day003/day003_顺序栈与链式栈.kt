package com.sy.leetcode.day003

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/16-17:12
 * @Email 609188080@qq.com
 */
// linked stack
class ListNode(var `val`: String) {
    var next: ListNode? = null
}


class LinkedStack() {
    private var first: ListNode? = null
    var size = 0

    fun push(string: String) {
        if (first == null) {
            first = ListNode(string)
        } else {
            val temp = ListNode(string)
            temp.next = first
            first = temp
        }
        size++
    }

    fun pop(): String {
        if (first == null) {
            throw EmptyStackException()
        } else {
            size--
            val returnNode = first
            first = first!!.next
            return returnNode!!.`val`
        }
    }

    fun peek(): String {
        return if (first == null) throw EmptyStackException() else first!!.`val`
    }

    fun poll(): String? {
        return if (first == null) {
            null
        } else {
            pop()
        }
    }

    fun isEmpty(): Boolean {
        return first == null
    }
}


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
        if (isEmpty()) throw EmptyStackException()
        return array[size - 1]
    }

    fun poll(): String? {
        if (isEmpty()) return null
        return pop()
    }
}

fun main() {
    val s = LinkedStack()
    s.push("1")
    s.push("2")
    s.push("3")
    s.size.print()
    s.poll().print()
    s.size.print()
    s.isEmpty().print()

}

fun <T> T.print() {
    println(this.toString())
}