package com.sy.leetcode.stack

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/19-16:18
 * @Email 609188080@qq.com
 */


// 1
// 面试题 03.02. 栈的最小值
// https://leetcode-cn.com/problems/min-stack-lcci/

class MinStack() {

    /** initialize your data structure here. */
    private val stack = LinkedList<Int>()
    private val stackMin = LinkedList<Int>()

    fun push(x: Int) {
        stackMin.push(Math.min(stackMin.peek() ?: Int.MAX_VALUE, x))
        stack.push(x)
    }

    fun pop() {
        stack.pop()
        stackMin.pop()
    }

    fun top(): Int {
        stack.peek()?.let {
            return it
        }
        throw EmptyStackException()
    }

    fun getMin(): Int {
        stackMin.peek()?.let {
            return it
        }
        throw EmptyStackException()
    }
}