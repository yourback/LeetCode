package com.sy.leetcode.daily.day012

import com.sy.leetcode.daily.day002.ListNode
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/26-15:51
 * @Email 609188080@qq.com
 */

// 83. 删除排序链表中的重复元素
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
// O(n)
fun deleteDuplicates(head: ListNode?): ListNode? {
    val hashSet = hashSetOf<Int>()
    var cur: ListNode? = head
    var pre: ListNode? = null
    while (cur != null) {
        if (cur.`val` !in hashSet) {
            hashSet.add(cur.`val`)
            pre = cur
            cur = cur.next
        } else {
            pre?.next = cur.next
            cur = cur.next
        }
    }
    return head
}

// O(n)
fun deleteDuplicates1(head: ListNode?): ListNode? {
    val stack = LinkedList<ListNode>()
    var cur: ListNode? = head
    while (cur != null) {
        val temp = cur.next
        cur.next = null
        if (stack.isEmpty() || stack.peek()!!.`val` != cur.`val`) stack.push(cur)
        cur = temp
    }
    var startNode: ListNode? = null
    while (stack.isNotEmpty()) {
        if (startNode == null) startNode = stack.pop()
        else {
            val temp = stack.pop()
            temp.next = startNode
            startNode = temp
        }
    }
    return startNode
}
