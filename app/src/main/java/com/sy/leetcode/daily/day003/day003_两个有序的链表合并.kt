package com.sy.leetcode.daily.day003

import com.sy.leetcode.daily.day002.ListNode

/**
 * @Author sy
 * @Date 2021/3/16-14:28
 * @Email 609188080@qq.com
 */

// ☆☆☆☆☆

// 剑指 Offer 25. 合并两个排序的链表
// https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
// 21. 合并两个有序链表
// https://leetcode-cn.com/problems/merge-two-sorted-lists/


// method 1, two points
// time ： O(m+n)   space: O(m+n)

fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    // temp points
    var head1 = l1
    var head2 = l2

    // get head
    val head: ListNode?
    if (head1.`val` < head2.`val`) {
        head = head1
        head1 = head1.next
    } else {
        head = head2
        head2 = head2.next
    }
    head.next = null

    var cur = head
    // littler one add new list
    while (head1 != null && head2 != null) {
        if (head1.`val` < head2.`val`) {
            cur!!.next = head1
            head1 = head1.next
            cur = cur.next
        } else {
            cur!!.next = head2
            head2 = head2.next
            cur = cur.next
        }
        cur!!.next = null
    }
    // add last nodes to news
    if (head1 == null) {
        cur!!.next = head2
    } else {
        cur!!.next = head1
    }

    return head
}


// method 2, use list`s sort
// add all numbers to new list
// sort
// make chain
// time ： O(m+n)   space: O(m+n)
fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    val l = arrayListOf<ListNode>()

    var head1 = l1
    while (head1 != null) {
        l.add(head1)
        head1 = head1.next
    }

    var head2 = l2
    while (head2 != null) {
        l.add(head2)
        head2 = head2.next
    }

    l.sortBy { it.`val` }

    var head: ListNode? = null
    var cur: ListNode? = null
    for (node in l) {
        if (head == null) {
            head = node
            cur = head
        } else {
            cur!!.next = node
            cur = cur.next
        }
    }
    return head
}


// method 3, one chain insert into another one in order
// time ： O(m+n)   space: O(1)
fun mergeTwoLists3(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    // l2 insert into l1 one by one
    var head1 = l1
    var cur = head1
    var head2 = l2
    var temp2: ListNode?
    while (head2 != null) {
        temp2 = head2
        head2 = head2.next
        temp2.next = null  // avoid cycle

        // operate on temp2
        var pre: ListNode? = null
        while (cur != null) {
            if (cur.`val` > temp2.`val`) break
            pre = cur
            cur = cur.next
        }
        if (pre == null) {
            // insert into start
            temp2.next = cur
            head1 = temp2
        } else if (cur == null) {
            // add at end
            pre.next = temp2
        } else {
            // insert into middle
            temp2.next = cur
            pre.next = temp2
        }
        cur = temp2
    }
    return head1
}