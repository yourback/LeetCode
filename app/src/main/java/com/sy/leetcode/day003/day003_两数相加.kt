package com.sy.leetcode.day003

import com.sy.leetcode.day002.ListNode

/**
 * @Author sy
 * @Date 2021/3/15-11:09
 * @Email 609188080@qq.com
 */

// 2. 两数相加
// https://leetcode-cn.com/problems/add-two-numbers/submissions/

// 方法一
// 转化成数字相加后，再逆序化成链表
// 超出int类型的最大值 报错
fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode {
    // l1 sum
    var i = 0
    var n1 = 0
    var cur1 = l1
    while (cur1 != null) {
        n1 += cur1.`val` * Math.pow(10.0, i.toDouble()).toInt()
        cur1 = cur1.next
        i++
    }
    // l2 sum
    i = 0
    var n2 = 0
    var cur2 = l2
    while (cur2 != null) {
        n2 += cur2.`val` * Math.pow(10.0, i.toDouble()).toInt()
        cur2 = cur2.next
        i++
    }
    n1 += n2

    val head = ListNode(n1 % 10)
    var cur: ListNode = head
    while (n1 / 10 != 0) {
        n1 /= 10
        cur.next = ListNode(n1 % 10)
        cur = cur.next!!
    }
    return head
}


// 方法二
// 因为是倒叙数字  且  进位只能是 1
// 两个指针指向 两个链的同一位 记录相加后是否有进位
// 时间复杂度 O(m+n)   O(m+n)

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    var pre1: ListNode? = null
    var cur1 = l1
    var cur2 = l2
    var carry = false
    while (cur1 != null && cur2 != null) {
        val sum = cur1.`val` + cur2.`val` + if (carry) 1 else 0
        carry = sum > 9
        cur1.`val` = sum % 10
        pre1 = cur1
        cur1 = cur1.next
        cur2 = cur2.next
    }
    // operate with carry
    if (cur1 == null) {
        pre1!!.next = cur2
    }
    cur1 = pre1
    while (cur1 != null) {
        val sum = cur1.`val` + if (carry) 1 else 0
        carry = sum > 9
        cur1.`val` = sum % 10
        pre1 = cur1
        cur1 = cur1.next
    }
    if (carry) {
        pre1!!.next = ListNode(1)
    }
    return l1
}

// 方法三
// 使用递归  报错栈溢出
fun addTwoNumbers3(l1: ListNode?, l2: ListNode?): ListNode {
    return getNode(l1, l2, 0)
}

fun getNode(l1: ListNode?, l2: ListNode?, carry: Int): ListNode {
    val sum = if (l1 == null) 0 else l1.`val` + if (l2 == null) 0 else l2.`val` + carry
    val curNode = ListNode(sum % 10)
    val curCarry = sum / 10
    if (l1?.next != null || l2?.next != null || curCarry != 0) {
        curNode.next = getNode(l1, l2, curCarry) // 栈溢出
    }
    return curNode
}


// 方法三
// 使用迭代
fun addTwoNumbers4(l1: ListNode?, l2: ListNode?): ListNode? {
    var head: ListNode? = null
    var end: ListNode? = null
    var tail1: ListNode? = l1
    var tail2: ListNode? = l2

    var carry = 0
    // l1 and l2 is not null
    while (tail1 != null || tail2 != null || carry != 0) {
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        if (head == null) {
            head = ListNode(sum % 10)
            end = head
        } else {
            end!!.next = ListNode(sum % 10)
            end = end.next
        }
        carry = sum / 10
        if (tail1 != null) tail1 = tail1.next
        if (tail2 != null) tail2 = tail2.next
    }
    return head
}
