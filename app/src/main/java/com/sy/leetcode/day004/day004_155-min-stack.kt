package com.sy.leetcode.day004

import com.sy.leetcode.day003.ListNode
import com.sy.leetcode.day003.print
import org.w3c.dom.NodeList
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

/**
 * @Author sy
 * @Date 2021/3/17-10:53
 * @Email 609188080@qq.com
 */

// LeetCode 155. Min Stack
// https://leetcode-cn.com/problems/min-stack/


// array stack
class MinStack {

    /** initialize your data structure here. */
    private var stack = ArrayList<Int>()
    var size = 0

    // time complexity O(1)
    fun push(x: Int) {
        stack.add(x)
        size++
    }

    // time complexity O(1)
    fun pop() {
        if (size == 0) return
        stack.removeAt(--size)
    }

    // time complexity O(1)
    fun top(): Int {
        return stack[size - 1]
    }

    // time complexity O(n)
    fun getMin(): Int {
        if (size == 0) throw EmptyStackException()
        else return stack.minOrNull()!!
    }
}


// linked stack
class Node(var `val`: Int) {
    var next: Node? = null
}

class MinStack1() {
    private var top: Node? = null

    // time complexity O(1)
    fun push(x: Int) {
        if (top == null) {
            top = Node(x)
        } else {
            val temp = Node(x)
            temp.next = top
            top = temp
        }
    }

    // time complexity O(1)
    fun pop() {
        if (top == null) throw EmptyStackException()
        else {
            top = top!!.next
        }
    }

    // time complexity O(1)
    fun top(): Int {
        if (top == null) {
            throw EmptyStackException()
        } else
            return top!!.`val`
    }

    // time complexity O(n) , n is the numbers of elements
    fun getMin(): Int {
        if (top == null) throw EmptyStackException()
        var cur = top
        var min: Int? = null
        while (cur != null) {
            if (min == null) min = cur.`val`
            min = Math.min(min, cur.`val`)
            cur = cur.next
        }
        return min!!
    }
}

// two stack
class MinStack2 {
    private val stack: LinkedList<Int> = LinkedList<Int>()
    private val minStack: LinkedList<Int> = LinkedList<Int>()

    // time complexity O(1)
    fun push(x: Int) {
        stack.push(x)
        minStack.peek()?.let {
            minStack.push(Math.min(it, x))
            return
        }
        minStack.push(x)
    }

    // time complexity O(1)
    fun pop() {
        stack.pop()
        minStack.pop()
    }

    // time complexity O(1)
    fun top(): Int {
        return stack.peek() ?: throw EmptyStackException()
    }

    // time complexity O(1)
    fun getMin(): Int {
        return minStack.peek() ?: throw EmptyStackException()
    }
}


//fun main() {
//    val minStack = MinStack2();
//    minStack.push(-2);
//    minStack.push(0);
//    minStack.push(-3);
//    minStack.getMin().print() // return -3
//    minStack.pop();
//    minStack.top().print()// return 0
//    minStack.getMin().print()
//}