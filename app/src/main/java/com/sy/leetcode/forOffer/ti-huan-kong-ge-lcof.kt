package com.sy.leetcode.forOffer

import com.sy.leetcode.daily.day003.print
import java.lang.StringBuilder

/**
 * @Author sy
 * @Date 2021/3/22-14:45
 * @Email 609188080@qq.com
 */

// 剑指 Offer 05. 替换空格
// https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

// StringBuilder
// O(n)
fun replaceSpace(s: String): String {
    val stringBuilder = StringBuilder()
    for (c in s) {
        if (c != ' ') {
            stringBuilder.append(c)
        } else {
            stringBuilder.append("%20")
        }
    }
    return stringBuilder.toString()
}


// array
// O(n)
fun replaceSpace1(s: String): String {
    var end = 0
    val array = CharArray(s.length * 3)
    for (c in s) {
        if (c != ' ') {
            array[end++] = c
        } else {
            array[end++] = '%'
            array[end++] = '2'
            array[end++] = '0'
        }
    }
    return String(array, 0, end)
}

fun main() {
    charArrayOf('1', '2').concatToString().print()
}



