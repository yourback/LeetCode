package com.sy.leetcode.queue

import com.sy.leetcode.daily.day003.print
import java.lang.Exception

/**
 * @Author sy
 * @Date 2021/3/22-10:23
 * @Email 609188080@qq.com
 */

class Node(val `val`: Int) {
    var next: Node? = null
}


// linked queue
class LinkedQueue {
    private var _size = 0
    val size get() = _size
    private var head: Node? = null
    private var tail: Node? = null

    fun enqueue(x: Int) {
        if (head == null) {
            head = Node(x)
            tail = head
        } else {
            tail!!.next = Node(x)
            tail = tail!!.next
        }
        _size++
    }

    fun dequeue(): Int {
        if (head == null) {
            throw Exception("empty queue")
        } else {
            val ret = head!!.`val`
            head = head!!.next
            _size--
            return ret
        }
    }

    fun isEmpty(): Boolean {
        return _size == 0
    }
}


fun main() {
    val lq = LinkedQueue()
    lq.enqueue(1)
    lq.enqueue(2)
    lq.enqueue(3)
    lq.enqueue(4)
    lq.enqueue(5)

    lq.isEmpty().print()
    lq.size.print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
    lq.dequeue().print()
}