package com.sy.leetcode.day003

import com.sy.leetcode.day002.ListNode
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/15-11:09
 * @Email 609188080@qq.com
 */

//剑指 Offer 22. 链表中倒数第k个节点

// 第一种方法，遍历两次  比如说要倒数第3个节点
// 第一遍遍历，确定总个数，第二遍遍历 遍历到总节点个数 - 3 停止  并返回当前节点
// 这里要注意的就是边界问题，
// 如 一共10个节点 倒数第三个  其实是第8个节点，
// 一共是n个节点，返回的应该是第n-2个节点
// 从新开始遍历 就要从 head开始遍历  执行7次  head.next   即执行n-3次 head.next
fun getKthFromEnd1(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    var i = 0
    var cur = head
    while (cur != null) {
        i++
        cur = cur.next
    }
    // get number of node
    // get the time of cur.next needed
    i -= k
    var j = 0
    cur = head
    while (j < i) {
        j++
        cur = cur!!.next
    }
    return cur
}


// 压栈，所有节点压栈，然后再弹出k次，则第k次弹出的节点，就是要返回的节点
fun getKthFromEnd2(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    val stack = Stack<ListNode>()
    var cur = head
    while (cur != null) {
        stack.push(cur)
        cur = cur.next
    }
    // all node in stack
    // how many times should pop from stack?
    // pop 1 -> last
    // pop 2 -> second last
    // pop 3 -> third from last
    // pop k -> kth from last
    var i = 0
    while (i < k) {
        cur = stack.pop()
        i++
    }
    return cur
}

// 利用hashmap，遍历列表的时候 生成  hashmap  {1：nodelist}
// 这样，遍历一次 获得节点总个数然后从hashmap中找到数字对应的节点返回
fun getKthFromEnd3(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    val hMap = hashMapOf<Int, ListNode>()
    // {1:head}
    // {2:second}
    // ...
    // {n:n th}
    var i = 1
    var cur = head
    while (cur != null) {
        hMap[i] = cur
        cur = cur.next
        i++
    }

    // i is the number of nodes
    // first from last  k=1 -> i
    // second from last k=2 -> i-1
    // third from last  k=3 -> i-2
    return hMap[i - k + 1]
}


// 方法四：方法一的协程版本
// 双指针
fun getKthFromEnd4(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    var former = head
    var later = head

    var i = 0
    while (former != null) {
        former = former.next
        i++
        if (i > k) later = later!!.next
    }
    return later
}