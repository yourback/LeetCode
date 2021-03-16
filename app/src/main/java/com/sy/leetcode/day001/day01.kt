package com.sy.leetcode.day001

/**
 * @Author sy
 * @Date 2021/3/9-8:49
 * @Email 609188080@qq.com
 */
fun main() {
//    replaceSpaces("Mr John Smith    ", 13).forEach(::print)
    val a = restoreString("codeleet", intArrayOf(4, 5, 6, 7, 0, 2, 1, 3))
    print(a)
}

fun restoreString(s: String, indices: IntArray): String {
    return String(CharArray(indices.size).apply {
        for (i in this.indices) {
            this[indices[i]] = s[i]
        }
    })
}


fun replaceSpaces(s: String, i: Int): String {
    return s.substring(0, i).replace(" ", "%20")
}


fun replaceSpaces2(S: String, length: Int): String {
    if (length == 0 || S.isEmpty()) return S
    var i = 0
    var j = 0
    val array = S.toCharArray()

    while (i < length) {
        if (S[i] == ' ') {
            array[j++] = '%'
            array[j++] = '2'
            array[j++] = '0'
        } else {
            array[j++] = S[i]
        }
        i++
    }

    return String(array, 0, j)
}


fun replaceSpaces1(S: String, length: Int): String {
    var j = 0
    val array = CharArray(length * 3)

    S.forEachIndexed { index, c ->
        if (index >= length) return@forEachIndexed
        if (c == ' ') {
            array[j++] = '%'
            array[j++] = '2'
            array[j++] = '0'
        } else {
            array[j++] = c
        }
    }
//    return array.concatToString(0, j)
    return String(array, 0, j)
}