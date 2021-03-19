package com.sy.leetcode.stack

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
        }else{
            val preC = stack.peek()
            if ((c.isUpperCase() && preC.isLowerCase() && preC.toUpperCase() == c)
                ||(c.isLowerCase() && preC.isUpperCase() && preC.toLowerCase() == c)) {
                stack.pop()
            }
        }
    }
    return "1"
}
