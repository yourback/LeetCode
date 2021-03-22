package com.sy.leetcode.daily.day008

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/3/22-9:20
 * @Email 609188080@qq.com
 */

// 191. 位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/

// O(k)   k = 32     O(1)
fun hammingWeight(n: Int): Int {
    var ret = 0
    for (i in 0..31) {
        if (n and (1 shl i) != 0) {
            ret++
        }
    }
    return ret
}

// O(k)   k = 32     O(1)
fun hammingWeight1(n: Int): Int {
    var ret = 0
    for (i in 0..31) {
        if ((n ushr i) and 1 != 0) {
            ret++
        }
    }
    return ret
}

// eliminate a '1' every cycle
// O(n)   n is the number of '1' ,worst time complexity is 32
fun hammingWeight2(n: Int): Int {
    var cur = n
    var ret = 0
    while (cur != 0) {
        ret++
        cur = cur and (cur - 1)
    }
    return ret
}


fun main() {
    hammingWeight(-1).print()
    hammingWeight1(-1).print()
    (-1 ushr 31).print()
}