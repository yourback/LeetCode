package com.sy.leetcode.daily.day008

import android.os.Looper
import com.sy.leetcode.daily.day003.print
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/22-16:25
 * @Email 609188080@qq.com
 */

// 面试题 16.26. 计算器
// https://leetcode-cn.com/problems/calculator-lcci/

// java stack 中的 operation stack
fun calculate(s: String): Int {
    val stackNum = LinkedList<Int>()
    val stackSymbol = LinkedList<Char>()
    var num = 0
    var lastIsNum = false

    var i = 0
    Loop@ while (i < s.length) {
        when (s[i]) {
            ' ' -> continue@Loop
            '+', '-', '*', '/' -> {
                if (stackSymbol.peek() == '*' || stackSymbol.peek() == '/') {
                    stackNum.push(calcNum(stackNum.pop(), stackNum.pop(), stackSymbol.pop()))
                } else {
                    stackSymbol.push(s[i])
                }
            }
            else -> {
                if (stackSymbol.peek() == '*' || stackSymbol.peek() == '/') {
                    stackNum.push(calcNum(stackNum.pop(), s[i].toInt() - 48, stackSymbol.pop()))
                } else {
                    stackNum.push(s[i].toInt() - 48)
                }
            }
        }
        i++
    }

    while (stackSymbol.isNotEmpty()) {
        val num1 = stackNum.pop() ?: 0
        val num2 = stackNum.pop() ?: 0
        val c = stackSymbol.pop()
        if (c == '+') {
            stackNum.push(num2 + num1)
        } else {
            stackNum.push(num2 - num1)
        }
    }
    return stackNum.pop()
}

fun calcNum(pop: Int?, toInt: Int, symbol: Char): Int {
    return if (symbol == '*') {
        (pop ?: 0) * toInt
    } else {
        (pop ?: 0) / toInt
    }
}

fun main() {
    calculate("3+2*2").print()
    calculate("3/2").print()
    calculate(" 3+5 / 2 ").print()


}