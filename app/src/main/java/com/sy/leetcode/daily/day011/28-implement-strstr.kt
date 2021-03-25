package com.sy.leetcode.daily.day011

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/25-8:35
 * @Email 609188080@qq.com
 */

// 28. 实现 strStr()
// https://leetcode-cn.com/problems/implement-strstr/


fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

// O(mn)
fun strStr1(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (needle.length > haystack.length) return -1
    for (i in haystack.indices) {
        if (haystack[i] == needle[0]) {
            var j = 0
            while (j < needle.length
                && i + j < haystack.length
                && haystack[i + j] == needle[j]
            ) {
                j++
            }
            if (j == needle.length) return i
        }
    }
    return -1
}

fun main() {
    val haystack = "aaaaa"
    val needle = "bba"


    strStr1("mississippi", "issipi").print()
}