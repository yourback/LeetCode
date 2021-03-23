package com.sy.leetcode.forOffer

import com.sy.leetcode.daily.day003.print
import java.lang.StringBuilder
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/23-11:31
 * @Email 609188080@qq.com
 */
// 剑指 Offer 58 - I. 翻转单词顺序
// https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/


// stack
// time complexity: O(n)
// space complexity: O(n)
fun reverseWords(s: String): String {
    val stack = LinkedList<String>()  // space = n
    var i = 0
    while (i < s.length) {  // time = n
        if (s[i] != ' ') {
            val curNumAndI = getCurWord(s, i)
            stack.push(curNumAndI.second)
            i = curNumAndI.first
            continue
        }
        i++
    }
    return stack.joinToString(" ")
}

fun getCurWord(s: String, i: Int): Pair<Int, String> {
    val stringBuilder = StringBuilder()
    var j = i
    while (j < s.length && s[j] != ' ') {
        stringBuilder.append(s[j])
        j++
    }
    return Pair(j, stringBuilder.toString())
}


// stringbuilder
// time complexity: O(n)
// space complexity: O(n)
fun reverseWords1(s: String): String {
    val stringBuilder = StringBuilder()   // space = n
    var i = s.length - 1

    while (i >= 0) {     // time is n
        if (s[i] != ' ') {
            val curWordAndI = getFlashBackCurWord(s, i)
            stringBuilder.append(curWordAndI.first + " ")
            i = curWordAndI.second
            continue
        }
        i--
    }
    return stringBuilder.toString().trim()
}

fun getFlashBackCurWord(s: String, i: Int): Pair<String, Int> {
    var j = i
    while (j >= 0 && s[j] != ' ') {
        j--
    }
    return Pair(s.substring(j + 1, i + 1), j)
}


fun main() {
    reverseWords1("the sky is blue...").print()
}
