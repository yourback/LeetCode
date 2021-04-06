package com.sy.leetcode.daily.day016

import java.lang.StringBuilder

// 14. 最长公共前缀
// https://leetcode-cn.com/problems/longest-common-prefix/

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var i = 0
    while (isICharIsSame(strs, i)) {
        i++
    }
    return strs[0].substring(0 until i)
}

fun isICharIsSame(strs: Array<String>, i: Int): Boolean {
    var sameChar: Char? = null
    for (s in strs) {
        if (i >= s.length) return false
        if (sameChar == null) {
            sameChar = s[i]
        } else {
            if (sameChar != s[i]) return false
        }
    }
    return true
}
