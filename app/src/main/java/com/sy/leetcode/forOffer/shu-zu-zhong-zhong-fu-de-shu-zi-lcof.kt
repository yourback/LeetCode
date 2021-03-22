package com.sy.leetcode.forOffer

/**
 * @Author sy
 * @Date 2021/3/22-14:27
 * @Email 609188080@qq.com
 */

// 剑指 Offer 03. 数组中重复的数字
// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

// O(n)
fun findRepeatNumber(nums: IntArray): Int {
    val hashSet = hashSetOf<Int>()
    for (num in nums) {
        if (num in hashSet) return num
        hashSet.add(num)
    }
    return 0
}