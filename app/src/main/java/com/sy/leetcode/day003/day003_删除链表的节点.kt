package com.sy.leetcode.day003

import com.sy.leetcode.day002.ListNode

/**
 * @Author sy
 * @Date 2021/3/15-11:09
 * @Email 609188080@qq.com
 */

//剑指 Offer 18. 删除链表的节点

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return head
    // if first node need delete
    if (head.`val` == `val`) return head.next
    // get each node`s val

    var pre = head
    var cur = pre.next
    while (cur != null && cur.`val` == `val`) {
        pre = cur
        cur = pre.next
    }
    pre!!.next = cur!!.next

    return head
}