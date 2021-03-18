package com.sy.leetcode.day005

import java.util.LinkedList


/**
 * @Author sy
 * @Date 2021/3/18-16:57
 * @Email 609188080@qq.com
 */
// 682. Baseball Game
// https://leetcode-cn.com/problems/baseball-game/

// time complexity O(n) n for ops`s size
// space complexity O(n) n for stack`size
fun calPoints(ops: Array<String>): Int {
    return LinkedList<Int>().apply {
        for (s in ops) {
            when (s) {
                "+" -> {
                    val num1 = pop()
                    val num2 = peek()
                    push(num1)
                    push(num1 + (num2 ?: 0))
                }
                "C" -> {
                    poll()
                }
                "D" -> {
                    peek()?.let {
                        push(it * 2)
                    }
                }
                else -> {
                    push(s.toInt())
                }
            }
        }
    }.reduce { acc, i -> acc + i }
}