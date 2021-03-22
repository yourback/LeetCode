package com.sy.leetcode.forOffer

import java.lang.StringBuilder

/**
 * @Author sy
 * @Date 2021/3/22-15:00
 * @Email 609188080@qq.com
 */
// 剑指 Offer 58 - II. 左旋转字符串
// https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

// sub
fun reverseLeftWords(s: String, n: Int): String {
    return s.substring(n until s.length) + s.substring(0 until n)
}

// stringbuilder
fun reverseLeftWords1(s: String, n: Int): String {
    return StringBuilder().apply {
        for (i in n until s.length)
            append(i)
        for (i in 0 until n)
            append(i)
    }.toString()
}