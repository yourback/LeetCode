package com.sy.leetcode.day005

/**
 * @Author sy
 * @Date 2021/3/18-17:25
 * @Email 609188080@qq.com
 */
// 496. Next Greater Element I
// https://leetcode-cn.com/problems/next-greater-element-i/

// force
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val array = arrayListOf<Int>()
    nums1.map {
        val i = nums2.indexOf(it)
        if (i == -1) array.add(-1) else {
            for (j in i until nums2.size) {
                if (nums2[j] > it) {
                    array.add(nums2[j])
                    break
                }
            }

        }
    }

}