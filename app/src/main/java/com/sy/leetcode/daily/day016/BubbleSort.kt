package com.sy.leetcode.daily.day016


fun bubbleSort(array: IntArray) {
    var sorted = false
    var i = 0
    while (i < array.size) {
        var j = 0
        while (j < array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                array[j] = array[j] xor array[j + 1]
                array[j + 1] = array[j + 1] xor array[j]
                array[j] = array[j] xor array[j + 1]
                sorted = true
            }
            j++
        }
        i++
        if (!sorted) break
    }
}


fun main() {
    val intArray = intArrayOf(10,4, 1, 20, 3, 9,6)
    bubbleSort(intArray)
    intArray.forEach(::print)
}