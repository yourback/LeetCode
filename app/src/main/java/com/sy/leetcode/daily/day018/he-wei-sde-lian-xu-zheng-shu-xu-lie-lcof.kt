package com.sy.leetcode.daily.day018

/**
 * @Author sy
 * @Date 2021/4/7-10:45
 * @Email 609188080@qq.com
 */

// 剑指 Offer 57 - II. 和为s的连续正数序列
// https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/

fun findContinuousSequence(target: Int): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    for (i in 1..target / 2) {
        val intArray = getIntArrayWithStart(i, target)
        if (intArray.isNotEmpty())
            result.add(intArray)
    }
    return result.toTypedArray()
}

fun getIntArrayWithStart(i: Int, target: Int): IntArray {
    var sum = 0
    var cur = i
    val result = mutableListOf<Int>()
    while (sum < target) {
        result.add(cur)
        sum += cur
        cur++
    }
    return if (sum == target) result.toIntArray() else intArrayOf()
}
