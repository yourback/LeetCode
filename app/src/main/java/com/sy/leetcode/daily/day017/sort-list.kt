package com.sy.leetcode.daily.day017

import com.sy.leetcode.daily.day002.ListNode
import java.util.*

/**
 * @Author sy
 * @Date 2021/4/6-11:26
 * @Email 609188080@qq.com
 */

// 148. 排序链表
// https://leetcode-cn.com/problems/sort-list/

// O(n^2) insert sort
fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val startNodeAndLastNode = getStartNode(head)
    var newHead = startNodeAndLastNode.first
    var curNode = startNodeAndLastNode.second

    while (curNode != null) {
        val curPair = getStartNode(curNode)
        newHead = insertIntoNewHead(newHead, curPair.first)
        curNode = curPair.second
    }
    return newHead
}

fun insertIntoNewHead(newHead: ListNode, first: ListNode): ListNode {
    var cur: ListNode? = newHead
    var pre: ListNode? = null
    if (first.`val` < newHead.`val`) {
        first.next = newHead
        return first
    } else {
        while (cur != null) {
            if (cur.`val` > first.`val`) break
            pre = cur
            cur = cur.next
        }
        if (cur == null) {
            pre?.next = first
        } else {
            first.next = cur
            pre?.next = first
        }
        return newHead
    }

}

fun getStartNode(head: ListNode): Pair<ListNode, ListNode?> {
    val curNode = head.next
    head.next = null
    return Pair(head, curNode)
}
