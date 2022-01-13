package com.daily.programmer.parking

import kotlin.math.absoluteValue


/**
 * Handles the parking mechanisms: park/unpark a car (also for disabled-only bays) and provides a string representation of its state.
 */
class Parking(private val size: Int, private val pedestrianExits: List<Int>, disabledBays: List<Int>) {

    private var parkingSpaces: MutableList<Char> = mutableListOf()

    init {
        for (i in 0..size * size) {
            if (pedestrianExits.contains(i)) {
                parkingSpaces.add(i, '=')
            } else if (disabledBays.contains(i)) {
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

        val index = getClosestToPedestrianExit(carType)

        if (index == -1) {
            return -1
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
        return parkingSpaces.windowed(5, 5).mapIndexed {index, chars ->
            if (index % 2 != 0) {
                chars.reversed().joinToString("")
            } else {
                chars.joinToString("")
            }
        }.joinToString("\n")
    }

    private fun getClosestToPedestrianExit(carType: Char): Int {
        var index = -1
        var min = Int.MAX_VALUE

        for (i in 0 until parkingSpaces.size) {

            if (!canParkCar(i, carType)) {
                continue
            }

            for (element in pedestrianExits) {
                val m = i - element
                if (m.absoluteValue < min) {
                    min = m.absoluteValue
                    index = i
                }
            }
        }

        return index
    }

    private fun isEmpty(c: Char): Boolean {
        return c == 'U' || c == '@'
    }

    private fun canParkCar(index: Int, carType: Char): Boolean {
        if (carType == 'D') {
            return parkingSpaces[index] == '@'
        }
        return parkingSpaces[index] == 'U'
    }

    private fun fillBay(index: Int, carType: Char) {
        parkingSpaces[index] = carType
    }

}
