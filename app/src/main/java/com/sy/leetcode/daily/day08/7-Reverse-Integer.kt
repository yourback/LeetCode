package com.sy.leetcode.daily.day08

import com.sy.leetcode.daily.day003.print

// 7. Reverse Integer
// https://leetcode-cn.com/problems/reverse-integer/

fun reverse(x: Int): Int {
    val xString = x.toString()
    return if (xString.startsWith("-")) {
        0 - xString.substring(1).reversed().toInt()
    } else {
        xString.reversed().toInt()
    }
}

fun main() {
//    reverse(1534236469)
    Int.MAX_VALUE.print()
    (Math.pow(2.0, 31.0) - 1).print()
}