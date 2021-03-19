package com.sy.leetcode.daily.day006

/**
 * @Author sy
 * @Date 2021/3/19-14:22
 * @Email 609188080@qq.com
 */


// ★★★★★
// 1603. Design Parking System
// https://leetcode-cn.com/problems/design-parking-system/

class ParkingSystem(big: Int, medium: Int, small: Int) {

    var bigCarCapacity = big
    var mediumCarCapacity = medium
    var smallCarCapacity = small

    fun addCar(carType: Int): Boolean {
        return when (carType) {
            1 -> {
                if (bigCarCapacity == 0) false
                else {
                    bigCarCapacity--
                    true
                }
            }
            2 -> {
                if (mediumCarCapacity == 0) false
                else {
                    mediumCarCapacity--
                    true
                }
            }
            3 -> {
                if (smallCarCapacity == 0) false
                else {
                    smallCarCapacity--
                    true
                }
            }
            else -> false
        }
    }
}