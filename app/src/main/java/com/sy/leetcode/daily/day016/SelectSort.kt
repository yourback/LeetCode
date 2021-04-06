package com.sy.leetcode.daily.day016


fun selectSort(array: IntArray) {
    var i = 0
    while (i < array.size) {
        val j = getMinValueIndex(array, i)
        if (j != -1 && j != i) {
            array[i] = array[j] xor array[i]
            array[j] = array[i] xor array[j]
            array[i] = array[j] xor array[i]
        }
        i++
    }
}

fun getMinValueIndex(array: IntArray, i: Int): Int {
    var minValue = Int.MAX_VALUE
    var minValueIndex = -1
    for (index in i until array.size) {
        if (minValue > array[index]) {
            minValue = array[index]
            minValueIndex = index
        }
    }
    return minValueIndex
}

fun main() {
    val intArray = intArrayOf(-1, 100, 10, 4, 1, 20, 3, 9, 6)
    selectSort(intArray)
    intArray.forEach(::print)
}