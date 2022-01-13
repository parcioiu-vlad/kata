package com.daily.programmer.parking


/**
 * Builder class to get a parking instance
 */
class ParkingBuilder {


    private var size: Int
    private var pedestrianExitIndexList: MutableList<Int>
    private var disabledBayIndexList: MutableList<Int>

    init {
        this.size = 0
        this.pedestrianExitIndexList = mutableListOf()
        this.disabledBayIndexList = mutableListOf()
    }

    fun withSquareSize(size: Int): ParkingBuilder {
        this.size = size
        return this
    }

    fun withPedestrianExit(pedestrianExitIndex: Int): ParkingBuilder {
        this.pedestrianExitIndexList.add(pedestrianExitIndex)
        return this
    }

    fun withDisabledBay(disabledBayIndex: Int): ParkingBuilder {
        this.disabledBayIndexList.add(disabledBayIndex)
        return this
    }

    fun build(): Parking {
        return Parking(this.size, this.pedestrianExitIndexList, this.disabledBayIndexList)
    }
}
