package com.sy.leetcode.daily.day006

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/19-15:54
 * @Email 609188080@qq.com
 */


// ★★★★★
// 剑指 Offer 09. 用两个栈实现队列
// https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/


class CQueue() {

    private val stack1 = LinkedList<Int>()
    private val stack2 = LinkedList<Int>()

    fun appendTail(value: Int) {
        stack1.push(value)
    }

    fun deleteHead(): Int {
        if (stack2.isEmpty()) stack1to2()
        return stack2.pop()
    }

    private fun stack1to2() {
        while (stack1.peek() != null) {
            stack2.push(stack1.pop())
        }
    }
}