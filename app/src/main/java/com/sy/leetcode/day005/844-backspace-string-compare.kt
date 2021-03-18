package com.sy.leetcode.day005

import com.sy.leetcode.day003.print
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/18-16:39
 * @Email 609188080@qq.com
 */

// 844. Backspace String Compare
// https://leetcode-cn.com/problems/backspace-string-compare/


// two stack
fun backspaceCompare(S: String, T: String): Boolean {
    val stackS = LinkedList<Char>()
    val stackT = LinkedList<Char>()
    for (s in S) {
        if (s == '#') stackS.poll()
        else {
            stackS.push(s)
        }
    }

    for (t in T) {
        if (t == '#') stackT.poll()
        else {
            stackT.push(t)
        }
    }

    while (stackS.isNotEmpty() && stackT.isNotEmpty()) {
        if (stackS.poll() != stackT.poll()) return false
    }
    return stackS.isEmpty() && stackT.isEmpty()
}

fun main() {
    backspaceCompare("ab#c", "ad#c").print()
    backspaceCompare("ab##", "c#d#").print()
    backspaceCompare("a##c", "#a#c").print()
    backspaceCompare("a#c", "b").print()
}