package com.sy.leetcode.forOffer

import java.lang.NumberFormatException
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/22-14:32
 * @Email 609188080@qq.com
 */

// 剑指 Offer 06. 从尾到头打印链表
// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// stack
fun reversePrint(head: ListNode?): IntArray {
    val stack = LinkedList<Int>()
    var cur = head
    while (cur != null) {
        stack.push(cur.`val`)
        cur = cur.next
    }
    return stack.toIntArray()
}