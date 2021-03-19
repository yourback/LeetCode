package com.sy.leetcode.daily.day006

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/19-14:39
 * @Email 609188080@qq.com
 */

// ★★★★☆
// 9. Palindrome Number
// https://leetcode-cn.com/problems/palindrome-number/

fun isPalindrome(x: Int): Boolean {
    val xString = x.toString()
    if (xString.length % 2 == 0) return false
    for (i in 0..(xString.length / 2)) {
        if (xString[i] != xString[xString.length - i - 1]) return false
    }
    return true
}

fun isPalindrome1(x: Int): Boolean {
    return x.toString().reversed() == x.toString()
}


fun main() {
    val a = "123"
    a[0].print()
    a[-1].print()
    a[-2].print()

}