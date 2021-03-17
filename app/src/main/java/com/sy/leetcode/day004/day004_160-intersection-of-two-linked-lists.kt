package com.sy.leetcode.day004

import com.sy.leetcode.day003.ListNode

/**
 * @Author sy
 * @Date 2021/3/17-15:42
 * @Email 609188080@qq.com
 */
// find same node`val and check the node`s val behind them whether still same
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var curA = headA
    var curB: ListNode?
    while (curA != null) {
        curB = headB
        while (curB != null) {
            if (curA.`val` == curB.`val` && isBehindSame(curA, curB)) {
                return curA
            }
            curB = curB.next
        }
        curA = curA.next
    }
    return null
}

fun isBehindSame(a: ListNode, b: ListNode): Boolean {
    var curA: ListNode? = a.next
    var curB: ListNode? = b.next
    while (curA != null && curB != null) {
        if (curA.`val` != curB.`val`) return false
        curA = curA.next
        curB = curB.next
    }
    return true
}

// there is something wrong when I read the description of question
// emmmmm   From now on, I see that finding the same address of nodes
// first appeared between two nodes lists is the solution to question


// method 1 : literate over two node list
// O(mn)   O(1)
fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
    var curA = headA
    var curB: ListNode?
    while (curA != null) {
        curB = headB
        while (curB != null) {
            if (curA == curB) {
                return curA
            }
            curB = curB.next
        }
        curA = curA.next
    }
    return null
}

// method 2 : use hashset
// O(m+n)   O(m/n)
fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
    val hashSet = hashSetOf<ListNode>()
    var curA = headA
    while (curA != null) {
        hashSet.add(curA)
        curA = curA.next
    }
    var curB = headB
    while (curB != null) {
        if (curB in hashSet) return curB
        curB = curB.next
    }
    return null
}

// method 3 : doubly-pointer
// O(m+n)   O(1)
fun getIntersectionNode3(headA: ListNode?, headB: ListNode?): ListNode? {
    var curA = headA
    var curB = headB
    while (curA != curB) {
        curA = if (curA == null) headB else curA.next
        curB = if (curB == null) headA else curB.next
    }
    return curA
}






