package com.sy.leetcode.daily

import java.util.*
import kotlin.math.max

/**
 * @Author sy
 * @Date 2021/4/1-10:40
 * @Email 609188080@qq.com
 */
// 剑指 Offer 59 - I. 滑动窗口的最大值
// https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/


// O(nk)
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val size = nums.size
    if (size == 0 || k == 0) return nums
    val array = IntArray(size - k + 1)
    for (i in 0..(size - k)) {
        var max = nums[i]
        for (j in 1 until k) {
            max = Math.max(max, nums[i + j])
        }
        array[i] = max
    }
    return array
}

// it does not work
// 9, 10, 9, -7, -4, -8, 2, -6
// 2 variables are not enough , try again with a queue
fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return nums
    val array = IntArray(nums.size - k + 1)

    var maxFirst = nums[0]
    var maxSecond = Int.MIN_VALUE

    var i = 1
    // 窗口形成前
    while (i < k) {
        val curNum = nums[i]
        if (curNum > maxFirst) {
            maxSecond = maxFirst
            maxFirst = curNum
        } else {
            maxSecond = Math.max(maxSecond, curNum)
        }
        i++
    }

    // 窗口形成且 窗口正好等于k
    var j = 0
    array[j] = maxFirst

    // 形成窗口后
    while (i < nums.size) {
        val curNum = nums[i]
        if (curNum > maxFirst) {
            maxSecond = maxFirst
            maxFirst = curNum
        } else {
            maxSecond = Math.max(maxSecond, curNum)
        }
        // 左边界移动前
        val leftNum = nums[j]
        if (leftNum == maxFirst) {
            maxFirst = maxSecond
            maxSecond = Int.MIN_VALUE
        }
        j++
        array[j] = maxFirst
        i++
    }
    return array
}


fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return nums
    val array = IntArray(nums.size - k + 1)

    val q = LinkedList<Int>()

    var i = 0
    // 窗口形成前
    while (i < k) {
        val curNum = nums[i]
        while (q.isNotEmpty() && q.peekLast()!! < curNum) {
            q.pollLast()
        }
        q.offerLast(curNum)
        i++
    }

    // 窗口形成且 窗口正好等于k
    var j = 0
    array[j] = q.peekFirst()!!

    // 形成窗口后
    while (i < nums.size) {
        val curNum = nums[i]
        while (q.isNotEmpty() && q.peekLast()!! < curNum) {
            q.pollLast()
        }
        q.offerLast(curNum)
        // 左边界移动前
        val leftNum = nums[j]
        if (q.peekFirst()!! == leftNum) {
            q.pollFirst()
        }
        j++
        array[j] = q.peekFirst()!!
        i++
    }
    return array
}

fun main() {
    val a = intArrayOf(
        9, 10, 9, -7, -4, -8, 2, -6
    )

    maxSlidingWindow1(a, 5).forEach(::print)
}
