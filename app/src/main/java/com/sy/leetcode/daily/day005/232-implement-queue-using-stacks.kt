package com.sy.leetcode.daily.day005

import com.sy.leetcode.daily.day003.print
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/18-16:15
 * @Email 609188080@qq.com
 */

// ☆☆☆☆☆

class MyQueue() {

    /** Initialize your data structure here. */
    private var stack1 = Stack<Int>()
    private var stack2 = Stack<Int>()

    private var stack1Num = 0

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stack1.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (stack2.isEmpty()) switchStacks()
        return stack2.pop()
    }

    private fun switchStacks() {
        while (!stack1.empty()) stack2.push(stack1.pop())
    }

    /** Get the front element. */
    fun peek(): Int {
        if (stack2.isEmpty()) switchStacks()
        return stack2.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.empty()
    }

}

fun main() {
    val obj = MyQueue()
    obj.push(1)
    obj.push(2)
    obj.push(3)
    obj.pop().print()
    obj.pop().print()
    obj.peek().print()
    obj.empty().print()
}