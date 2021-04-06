import com.sy.leetcode.daily.day002.ListNode

// 61. 旋转链表
// https://leetcode-cn.com/problems/rotate-list/


fun getEndNodeStartWith(startNode: ListNode): ListNode {
    var curNode: ListNode? = startNode
    var preNode: ListNode? = null
    var nextNode: ListNode? = startNode.next
    while (nextNode != null) {
        preNode = curNode
        curNode = nextNode
        nextNode = nextNode.next
    }
    preNode!!.next = null
    return curNode!!
}

fun getListNodeSize(head: ListNode): Int {
    var i = 0
    var cur: ListNode? = head
    while (cur != null) {
        i++
        cur = cur.next
    }
    return i
}


// O(nk)
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head

    val listNodeSize = getListNodeSize(head)

    val moveTimes = k % listNodeSize

    var startNode = head
    repeat(moveTimes) {
        val temp = getEndNodeStartWith(startNode!!)
        temp.next = startNode
        startNode = temp
    }

    return startNode
}


fun rotateRight1(head: ListNode?, k: Int): ListNode? {
    if (k == 0 || head?.next == null) return head

    val listNodeSize = getListNodeSize(head)
    var moveTime = listNodeSize - k % listNodeSize
    if (moveTime == 0) return head

    makeCycle(head)

    var cur = head
    while (moveTime-- > 0) {
        cur = cur?.next
    }
    val returnNode = cur?.next
    cur?.next = null
    return returnNode
}

fun makeCycle(head: ListNode) {
    var curNode: ListNode = head
    while (curNode.next != null) {
        curNode = curNode.next!!
    }
    curNode.next = head
}

fun main() {
    var a = ListNode(0)
    var b = ListNode(1)
    var c = ListNode(2)
    a.next = b
    b.next = c
    val returnNode = rotateRight1(a, 1)
    while (returnNode != null) {
        println("${returnNode.`val`}")
    }
}



