package com.sy.leetcode.day002

import java.lang.NullPointerException
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/11-13:43
 * @Email 609188080@qq.com
 */
public class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// 1 遍历将数字放入栈中然后 循环将栈中数据吐出
fun reverseList1(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    // 新建栈
    val stk = LinkedList<ListNode>()
    var h = head
    while (h != null) {
        stk.push(h)
        h = h.next
    }

    // pop
    val newHead = stk.pop()
    var end = newHead
    while (stk.isNotEmpty()) {
        // 从栈取出
        val temp = stk.pop()
        // 放到现有链表的最后一个后面
        end.next = temp
        // end指针指向最后一个
        end = temp
    }
    // 最后指针指向null
    end.next = null
    return newHead
}

// 2 每一次获取到最后的节点然后放到newhead后面
fun reverseList2(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    // new head
    val newHead = getLastNode(head)
    var end = newHead
    while (head.next != null) {
        val temp = getLastNode(head)
        end.next = temp
        end = temp
    }
    end.next = head
    head.next = null

    return newHead
}

fun getLastNode(head: ListNode): ListNode {
    if (head.next == null) return head

    var proNode = head
    var nextNode = proNode.next!!

    while (nextNode.next != null) {
        proNode = nextNode
        nextNode = proNode.next!!
    }
    proNode.next = null
    return nextNode
}

// 3 新建newhead然后第一次后面，然后都用插入法进行节点插入
fun reverseList3(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    // new head
    val newHead = ListNode(0)
    // get first node
    var oldHead = head
    var newEnd = oldHead
    oldHead = newEnd.next
    newEnd.next = null
    // set new head`s back
    newHead.next = newEnd

    // oldHead is the first of listNode
    // get each node and insert it between newHead and oldHead
    while (oldHead != null) {
        // get first node of old list
        val temp = oldHead.next

        // insert into new list
        oldHead.next = newEnd
        newHead.next = oldHead
        newEnd = oldHead

        oldHead = temp
    }
    return newHead
}

// 4 前指针后指针   然后依次往后推迟
fun reverseList4(head: ListNode?): ListNode? {
    var proNode: ListNode? = null
    var curNode = head

    while (curNode != null) {
        val nextNode = curNode.next
        curNode.next = proNode
        proNode = curNode
        curNode = nextNode
    }

    return proNode
}




