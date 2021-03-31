package com.sy.leetcode.daily.day011

import com.sy.leetcode.daily.day002.ListNode
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/25-16:46
 * @Email 609188080@qq.com
 */

// 82. 删除排序链表中的重复元素 II
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/


// O(n)
fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val stack = LinkedList<ListNode>()
    var cur = head
    var hasSameVal = false
    while (cur != null) {
        if (stack.isEmpty()) stack.push(cur)
        else {
            if (stack.peek()!!.`val` == cur.`val`) {
                hasSameVal = true
            } else {
                if (hasSameVal) {
                    stack.pop()
                    hasSameVal = false
                }
                stack.push(cur)
            }
        }
        cur = cur.next
    }
    if (hasSameVal) stack.pop()

    var start = stack.poll()
    start?.next = null

    while (stack.peek() != null) {
        val temp = stack.pop()
        temp.next = start
        start = temp
    }

    return start
}


fun main() {

}

