package com.sy.leetcode.daily.day015

import com.sy.leetcode.daily.day003.print

/**
 * @Author sy
 * @Date 2021/4/2-8:46
 * @Email 609188080@qq.com
 */

// 面试题 17.21. 直方图的水量
// volume-of-histogram-lcci


fun trap(height: IntArray): Int {
    var result = 0
    val eliminateHeightBottom = { arr: IntArray ->
        var i = 0
        while (i < arr.size) {
            if (arr[i] > 0)
                arr[i]--
            i++
        }
    }

    while (height.canSaveWater()) {
        result += height.getSavedWater()
        eliminateHeightBottom(height)
    }

    return result
}

private fun IntArray.getSavedWater(): Int {
    var startIndex = -1
    var result = 0
    for (i in this.indices) {
        if (this[i] != 0 && startIndex == -1) {
            startIndex = i
        } else if (this[i] != 0 && startIndex != -1) {
            result += (i - startIndex - 1)
            startIndex = i
        }
    }
    return result
}


private fun IntArray.canSaveWater(): Boolean {
    var heights = 0
    for (i in this) {
        if (i != 0) {
            heights++
        }
        if (heights > 1) return true
    }
    return heights > 1
}


fun trap1(height: IntArray): Int {
    var result = 0
    var minimumHeight = 1

    while (height.canSaveWater(minimumHeight)) {
        result += height.getSavedWater(minimumHeight)
        minimumHeight++
    }

    return result
}

private fun IntArray.getSavedWater(minimumHeight: Int): Int {
    var startIndex = -1
    var result = 0
    for (i in this.indices) {
        if (this[i] >= minimumHeight && startIndex == -1) {
            startIndex = i
        } else if (this[i] >= minimumHeight && startIndex != -1) {
            result += (i - startIndex - 1)
            startIndex = i
        }
    }
    return result
}


private fun IntArray.canSaveWater(minimumHeight: Int): Boolean {
    var heights = 0
    for (i in this) {
        if (i >= minimumHeight) {
            heights++
        }
        if (heights > 1) return true
    }
    return heights > 1
}


fun main() {
    val a = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    trap1(a).print()
}
