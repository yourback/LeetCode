package com.sy.leetcode.stack

import com.sy.leetcode.daily.day003.print
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/19-16:34
 * @Email 609188080@qq.com
 */

// 1598. 文件夹操作日志搜集器
// https://leetcode-cn.com/problems/crawler-log-folder/
fun minOperations(logs: Array<String>): Int {
    val stack = LinkedList<Int>()

    for (s in logs) {
        when (s) {
            "../" -> stack.poll()
            "./" -> continue
            else -> stack.push(1)
        }
    }

    return if (stack.isNotEmpty()) stack.reduce { acc, i -> acc + i } else 0

}

fun main() {
    minOperations(arrayOf("d1/", "d2/", "./", "d3/", "../", "d31/")).print()
    minOperations(arrayOf("d1/", "../", "../", "../")).print()
}