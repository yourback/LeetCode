package com.sy.leetcode.stack

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val stack = LinkedList<Int>()
    var temp = 0

    // if digit push in stack
    // if not digit pop 2 num
    for (i in tokens) {
        when (i) {
            "+" -> {
                val pop1 = stack.pop()
                val pop2 = stack.pop()
                temp = (pop2 ?: 0) + (pop1 ?: 0)
                stack.push(temp)
            }
            "-" -> {
                val pop1 = stack.pop()
                val pop2 = stack.pop()
                temp = (pop2 ?: 0) - (pop1 ?: 0)
                stack.push(temp)
            }
            "*" -> {
                val pop1 = stack.pop()
                val pop2 = stack.pop()
                temp = (pop2 ?: 0) * (pop1 ?: 0)
                stack.push(temp)
            }
            "/" -> {
                val pop1 = stack.pop()
                val pop2 = stack.pop()
                temp = (pop2 ?: 0) / (pop1 ?: 0)
                stack.push(temp)
            }
            else -> stack.push(i.toInt())
        }
    }
    return if (stack.isEmpty())
        temp
    else stack.pop()
}