package com.daily.programmer.parking

import kotlin.math.absoluteValue


/**
 * Handles the parking mechanisms: park/unpark a car (also for disabled-only bays) and provides a string representation of its state.
 */
class Parking(private val size: Int, private val pedestrianExitIndexList: List<Int>, disabledBayIndexList: List<Int>) {

    private var parkingSpaces: MutableList<Char> = mutableListOf()

    init {
        for (i in 0..size * size) {
            if (pedestrianExitIndexList.contains(i)) {
                parkingSpaces.add(i, '=')
            } else if (disabledBayIndexList.contains(i)) {
                parkingSpaces.add(i, '@')
            } else {
                parkingSpaces.add(i, 'U')
            }
        }
    }

    /**
     * @return the number of available parking bays left
     */
    fun getAvailableBays(): Int {
        return this.parkingSpaces.count { parkingSpace -> isEmpty(parkingSpace) } - 1
    }

    /**
     * Park the car of the given type ('D' being dedicated to disabled people) in closest -to pedestrian exit- and first (starting from the parking's entrance)
     * available bay. Disabled people can only park on dedicated bays.
     *
     *
     * @param carType
     * the car char representation that has to be parked
     * @return bay index of the parked car, -1 if no applicable bay found
     */
    fun parkCar(carType: Char): Int {

        if (getAvailableBays() <= 0) {
            return -1
        }

        val emptyBays = getEmptyBays(carType)

        if (emptyBays.isEmpty()) {
            return -1
        }

        var index = -1;
        var min = Int.MAX_VALUE

        for (i in 0 until parkingSpaces.size) {

            if (!canParkCar(i, carType)) {
                continue
            }

            for (element in pedestrianExitIndexList) {
                val m = i - element
                if (m.absoluteValue < min) {
                    min = m.absoluteValue
                    index = i
                }
            }
        }

        fillBay(index, carType)

        return index
    }

    /**
     * Unpark the car from the given index
     *
     * @param index
     * @return true if a car was parked in the bay, false otherwise
     */
    fun unparkCar(index: Int): Boolean {
        if (index > parkingSpaces.size - 1) {
            return false
        }

        val car = parkingSpaces[index]

        if (isEmpty(car) || car == '=') {
            return false
        }

        if (car == 'D') {
            parkingSpaces[index] = '@'
        } else {
            parkingSpaces[index] = 'U'
        }

        return true
    }

    /**
     * Print a 2-dimensional representation of the parking with the following rules:
     *
     *  * '=' is a pedestrian exit
     *  * '@' is a disabled-only empty bay
     *  * 'U' is a non-disabled empty bay
     *  * 'D' is a disabled-only occupied bay
     *  * the char representation of a parked vehicle for non-empty bays.
     *
     * U, D, @ and = can be considered as reserved chars.
     *
     * Once an end of lane is reached, then the next lane is reversed (to represent the fact that cars need to turn around)
     *
     * @return the string representation of the parking as a 2-dimensional square. Note that cars do a U turn to continue to the next lane.
     */
    override fun toString(): String {

        val parkingString: MutableList<String> = mutableListOf()
        var from = 0
        var to = size

        for (i in 0 until size) {

            if (i % 2 != 0) {
                val sublist = ArrayList(parkingSpaces.subList(from, to))
                sublist.reverse()

                parkingString.add(sublist.joinToString(""))
            } else {
                parkingString.add(parkingSpaces.subList(from, to).joinToString(""))
            }

            from += size
            to += size
        }

        return parkingString.joinToString("\n")
    }

    private fun isEmpty(c: Char): Boolean {
        return c == 'U' || c == '@'
    }

    private fun getEmptyBays(carType: Char): List<Char> {
        if (carType == 'D') {
            return this.parkingSpaces.filter { parkingSpace -> parkingSpace == '@' }
        }
        return this.parkingSpaces.filter { parkingSpace -> parkingSpace == 'U' }
    }

    private fun canParkCar(index: Int, carType: Char): Boolean {
        if (carType == 'D') {
            return parkingSpaces[index] == '@'
        }
        return parkingSpaces[index] == 'U'
    }

    private fun fillBay(index: Int, carType: Char) {
        if (carType == 'D') {
            parkingSpaces[index] = 'D'
        } else {
            parkingSpaces[index] = carType
        }
    }

}
