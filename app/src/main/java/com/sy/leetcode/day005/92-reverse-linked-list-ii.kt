package com.sy.leetcode.day005


/**
 * @Author sy
 * @Date 2021/3/18-8:51
 * @Email 609188080@qq.com
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    val a = reverseBetween1(ListNode(5), 1, 1)
    print(a?.`val`)
}


fun reverseLinkedList(head: ListNode?) {
    var pre: ListNode? = null
    var cur = head

    while (cur != null) {
        val next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
}

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

    var cur = head
    var pre: ListNode? = null

    var start: ListNode? = null
    var end: ListNode? = null

    var middleStart: ListNode? = null
    var middleEnd: ListNode? = null

    var i = 1

    // find four node
    while (cur != null) {
        if (i == left) {
            middleStart = cur
            start = pre
        }
        if (i == right) {
            middleEnd = cur
            end = cur.next
        }
        if (i > right) break
        pre = cur
        cur = cur.next
        i++
    }

    // cut
    start?.next = null
    middleEnd?.next = null

    // reverse
    reverseLinkedList(middleStart)

    // mix
    return if (start == null) {
        middleStart?.next = end
        middleEnd
    } else {
        start.next = middleEnd
        middleStart?.next = end
        head
    }
}


//the node  i in left +1 .. right insert  between front node and behind node
fun reverseBetween1(head: ListNode?, left: Int, right: Int): ListNode? {
    var frontNode: ListNode? = null
    var behindNode: ListNode? = null

    var pre: ListNode? = null
    var cur = head

    var i = 1
    while (cur != null) {
        if (i <= left) {
            frontNode = pre
            behindNode = cur
            pre = cur
            cur = cur.next
        } else if (i in left + 1..right) {
            val temp = cur
            cur = cur.next
            pre?.next = cur

            temp.next = behindNode
            frontNode?.next = temp
            behindNode = temp
        } else if (i > right) break
        i++
    }
    if (frontNode == null) {
        return behindNode
    }
    return head
}