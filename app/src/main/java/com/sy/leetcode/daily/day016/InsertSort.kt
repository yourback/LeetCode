package com.sy.leetcode.daily.day016

fun insertSort(array: IntArray) {
    var i = 1
    while (i < array.size) {
        val value = array[i]
        var j = i - 1
        while (j >= 0) {
            if (array[j] > value) {
                array[j + 1] = array[j]
            } else {
                break
            }
            j--
        }
        array[j + 1] = value
        i++
    }
}


fun main() {
    val intArray = intArrayOf(10, 4, 1, 20, 3, 9, 6)
    insertSort(intArray)
    intArray.forEach(::print)
}