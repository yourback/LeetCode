package com.sy.leetcode.daily.day008

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

    val symbolPlus = charArrayOf('+', '-')
    val symbolMultiplication = charArrayOf('*', '/')

    val calcLastPlus = {
        // if last symbol is '+' / '-' and cur symbol is '+' / '-'
        // 弹出数据算前面的 进行计算
        if ((stackSymbol.peek() ?: '@') in symbolPlus) {
            val n1 = stackNum.pop()
            val n2 = stackNum.pop()
            stackNum.push(calcPlus(n1, n2, stackSymbol.pop()))
        }
    }

    val calcLastMultiplication = { num: Int ->
        // 如果运算符栈顶位 乘除法 则直接运算
        if (stackSymbol.peek() ?: '@' in symbolMultiplication) {
            stackNum.push(calcMultiplication(num, stackNum.pop(), stackSymbol.pop()))
        } else {
            stackNum.push(num)
        }
    }


    var i = 0
    Loop@ while (i < s.length) {
        when {
            s[i].isDigit() -> {
                // 获得当前数字
                val curNumAndI = getCurNum(i, s)
                // 计算上一个乘除法
                calcLastMultiplication.invoke(curNumAndI.first)
                i = curNumAndI.second
                continue@Loop
            }
            s[i] in symbolPlus -> {
                // 计算上一个加减法
                calcLastPlus.invoke()
                stackSymbol.push(s[i])
            }
            s[i] in symbolMultiplication -> {
                stackSymbol.push(s[i])
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

private fun getCurNum(i: Int, s: String): Pair<Int, Int> {
    var i1 = i
    var num = 0
    while (i1 < s.length && s[i1].isDigit()) {
        num = num * 10 + (s[i1] - '0')
        i1++
    }
    return Pair(num, i1)
}

fun calcPlus(n1: Int, n2: Int, c: Char): Int {
    return if (c == '+')
        n1 + n2 else n2 - n1
}

fun calcMultiplication(pop1: Int, pop2: Int, symbol: Char): Int {
    return if (symbol == '*') {
        pop2 * pop1
    } else {
        pop2 / pop1
    }
}

fun main() {
    calculate("3+2*2").print()
    calculate("3/2").print()
    calculate(" 3+5 / 2 ").print()
    calculate("9- 52*10 + 2 ").print()
    calculate("1-1+1").print()
}