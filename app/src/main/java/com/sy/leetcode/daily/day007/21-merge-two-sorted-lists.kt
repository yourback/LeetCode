package com.sy.leetcode.daily.day007

import com.sy.leetcode.daily.day002.ListNode


//21. 合并两个有序链表
//https://leetcode-cn.com/problems/merge-two-sorted-lists/

// time complexity : O(m+n)
// space complexity : O(1)
// 迭代
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var cur1 = l1
    var cur2 = l2
    val newHead = ListNode(0)
    var newCur: ListNode = newHead

    while (cur1 != null || cur2 != null) {
        if (cur1?.`val` ?: Int.MAX_VALUE > cur2?.`val` ?: Int.MAX_VALUE) {
            newCur.next = cur2
            cur2 = cur2?.next
        } else {
            newCur.next = cur1
            cur1 = cur1?.next
        }
        newCur = newCur.next!!
    }
    return newHead.next
}

// 递归
// time complexity : O(m+n)
// space complexity : O(m+n)
fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
    val newHead = ListNode(0)
    merge(newHead, l1, l2)
    return newHead.next
}

fun merge(pre: ListNode, l1: ListNode?, l2: ListNode?) {
    if (l1 == null && l2 == null) return
    var cur1 = Int.MAX_VALUE
    var cur2 = Int.MAX_VALUE
    l1?.let {
        cur1 = it.`val`
    }
    l2?.let {
        cur2 = it.`val`
    }
    if (cur1 > cur2) {
        pre.next = l2
        merge(pre.next!!, l1, l2?.next)
    } else {
        pre.next = l1
        merge(pre.next!!, l1?.next, l2)
    }
}

