package com.sy.leetcode.daily.day005

import com.sy.leetcode.daily.day003.print
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/18-17:25
 * @Email 609188080@qq.com
 */

// ☆☆☆☆☆

// 496. Next Greater Element I
// https://leetcode-cn.com/problems/next-greater-element-i/

// force1
// O(m*n)   O(m)
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val array = arrayListOf<Int>()
    nums1.map {
        var i = nums2.indexOf(it)
        while (i < nums2.size) {
            if (nums2[i] > it) {
                array.add(nums2[i])
                break
            }
            i++
        }
        if (i == nums2.size) {
            array.add(-1)
        }
    }
    return array.toIntArray()
}


// force2
// O(m*n)   O(m)
fun nextGreaterElement2(nums1: IntArray, nums2: IntArray): IntArray {
    return IntArray(nums1.size).apply {
        nums1.mapIndexed { index, i ->
            var num = -1
            for (j in nums2.indexOf(i) + 1 until nums2.size) {
                if (nums2[j] > i) {
                    num = nums2[j]
                    break
                }
            }
            this[index] = num
        }
    }
}


// simple stack
// time complexity O(m+n)
// space complexity O(m+n)  stack and int array
fun nextGreaterElement3(nums1: IntArray, nums2: IntArray): IntArray {
    val stack = LinkedList<Int>()
    val map = hashMapOf<Int, Int>()
    for (i in nums2) {
        while (i > (stack.peek() ?: Int.MAX_VALUE))
            map[stack.pop()] = i
        stack.push(i)
    }
    return IntArray(nums1.size).apply {
        for (i in nums1.indices) {
            this[i] = map[nums1[i]] ?: -1
        }
    }
}

fun main() {
//    val a = nextGreaterElement3(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
    val a = nextGreaterElement3(intArrayOf(2, 4), intArrayOf(1, 2, 3, 4))
    a.forEach { it.print() }
}