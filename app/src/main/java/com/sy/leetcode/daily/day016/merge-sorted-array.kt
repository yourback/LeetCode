package com.sy.leetcode.daily.day016

import java.util.*

// 88. 合并两个有序数组
// https://leetcode-cn.com/problems/merge-sorted-array/

// force
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var j = 0
    for (i in nums1.indices) {
        if (i >= m) {
            nums1[i] = nums2[j]
            j++
        }
    }

    nums1.sort()
}


// stack
// O(m+n)
fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val stack = LinkedList<Int>()
    var i = 0
    var j = 0
    while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
            stack.offerLast(nums1[i++])
        } else {
            stack.offerLast(nums2[j++])
        }
    }
    if (i == m) {
        while (j < n) {
            stack.offerLast(nums2[j++])
        }
    } else {
        while (i < m) {
            stack.offerLast(nums1[i++])
        }
    }

    for (k in nums1.indices) {
        nums1[k] = stack.pollFirst()
    }
}


// reversed doubly pointer
fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var end = nums1.size - 1
    var nums1End = m - 1
    var nums2End = n - 1
    while (end >= 0 && nums1End >= 0 && nums2End >= 0) {
        nums1[end--] = if (nums1[nums1End] > nums2[nums2End]) nums1[nums1End--] else nums2[nums2End--]
    }
    if (nums1End == -1) {
        while (end >= 0)
            nums1[end--] = nums2[nums2End--]
    } else {
        while (end >= 0)
            nums1[end--] = nums1[nums1End--]
    }
}
