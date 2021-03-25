package com.sy.leetcode.daily.day010

import com.sy.leetcode.daily.day003.print
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * @Author sy
 * @Date 2021/3/24-8:40
 * @Email 609188080@qq.com
 */
// 456. 132模式
// https://leetcode-cn.com/problems/132-pattern/

// time complexity :  O(n^2)
fun find132pattern(nums: IntArray): Boolean {
    if (nums.size < 3) return false
    var num1 = nums[0]
    for (i in nums.indices) {
        for (j in nums.lastIndex downTo i) {
            if (num1 < nums[j] && nums[j] < nums[i]) return true
        }
        num1 = Math.min(num1, nums[i])
    }
    return false
}


// 单调栈
fun find132pattern2(nums: IntArray): Boolean {
    val stack = LinkedList<Int>()
    val array = IntArray(nums.size).apply {
        this[0] = nums[0]
    }
    // find  min with i
    for (i in 1 until nums.size) {
        array[i] = Math.min(array[i - 1], nums[i])
    }

    // simple stack
    for (j in (nums.size - 1) downTo 0) {
        if (stack.isEmpty()) {
            stack.push(nums[j])
        } else {
            var secondLargest = Int.MIN_VALUE
            while (stack.isNotEmpty() && stack.peek()!! < nums[j]) secondLargest = stack.pop()
            if (secondLargest > array[j]) return true
            stack.push(nums[j])
        }
    }
    return false
}

// 使用数组可以 得到在位置i 之前 最大或者最小的数字
// 单调栈 可以针对 最大，次大...   最小，次小... 中使用


fun main() {
    find132pattern2(intArrayOf(1, 2, 3, 4)).print()
    find132pattern2(intArrayOf(3, 1, 4, 2)).print()
    find132pattern2(intArrayOf(1, 0, 1, -4, -3)).print()
    find132pattern2(intArrayOf(-1, 3, 2, 0)).print()
}