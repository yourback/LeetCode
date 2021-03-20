package com.sy.leetcode.stack

import com.sy.leetcode.daily.day003.print
import java.lang.StringBuilder
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/19-16:52
 * @Email 609188080@qq.com
 */

// 1544. 整理字符串
// https://leetcode-cn.com/problems/make-the-string-great/


fun makeGood(s: String): String {
    val stack = LinkedList<Char>()
    for (c in s) {
        if (stack.isEmpty()) {
            stack.push(c)
        } else {
            val preC = stack.peek()
            if (c - preC == 32 || c - preC == -32) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
    }


    return StringBuilder().apply {
        while (stack.peek() != null)
            this.insert(0, stack.pop())
    }.toString()
}


fun makeGood1(s: String): String {
    return StringBuilder().apply {
        var i = 0
        while (i + 1 < s.length) {
            if (s[i] - s[i + 1] != 32 && s[i] - s[i + 1] != -32) {
                append(s[i])
                i++
            }else{
                i+=2
            }
        }
        append(s[i])
    }.toString()
}


fun main() {
    makeGood1("leEeetcode").print()
}
