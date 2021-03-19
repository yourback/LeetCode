package com.sy.leetcode.daily.day004

import java.util.*

/**
 * @Author sy
 * @Date 2021/3/17-10:53
 * @Email 609188080@qq.com
 */

// ☆☆☆☆☆

// LeetCode 20. Valid Parentheses
// https://leetcode-cn.com/problems/valid-parentheses/

// use stack
// P.S peek and poll is not same
// when stack is empty, peek() return an exception but poll() return null ,otherwise return an element
// time complexity O(n)
// space complexity O(n)

fun isValid(s: String): Boolean {
    if (s.isEmpty() || s.length % 2 == 1) return false
    val stack = LinkedList<Char>()

    loop@ for (c in s) {    // leetcode needs loop@
        if (c in "{[(") {
            stack.push(c)
        } else {
            return when (c) {
                '}' -> if (stack.poll() == '{') continue@loop else false
                ']' -> if (stack.poll() == '[') continue@loop else false
                ')' -> if (stack.poll() == '(') continue@loop else false
                else -> false
            }
        }
    }
    return stack.isEmpty()
}