package com.sy.leetcode.daily.day009

import java.util.*
import kotlin.io.print

/**
 * @Author sy
 * @Date 2021/3/23-10:43
 * @Email 609188080@qq.com
 */

// 739. 每日温度
// https://leetcode-cn.com/problems/daily-temperatures/

// 双循环
// time complexity :O(nm)  n is T.size , m is T.sub(n+1,T.size)
// space complexity :O(n)
fun dailyTemperatures(T: IntArray): IntArray {
    val intArray = IntArray(T.size)
    var i = 0
    while (i < T.size) {
        var j = i + 1
        while (j < T.size) {
            if (T[j] > T[i]) {
                intArray[i] = j - i
                break
            }
            j++
        }
        i++
    }
    return intArray
}


// simple stack
// time complexity : O(n)
// space complexity : O(n)

fun dailyTemperatures1(T: IntArray): IntArray {
    val stack = LinkedList<Int>()   // space < n
    val intArray = IntArray(T.size) // space = n
    val getT = { i: Int? ->
        if (i == null) Int.MAX_VALUE else T[i]
    }

    var i = 0
    while (i < T.size) {  // time = n
        val curT = getT.invoke(i)
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (getT.invoke(stack.peek()) < curT) {
                intArray[stack.peek()!!] = i - stack.pop()!!
            }
            stack.push(i)
        }
        i++
    }
    return intArray
}


fun main() {
    val a = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    dailyTemperatures1(a).forEach(::print)
}