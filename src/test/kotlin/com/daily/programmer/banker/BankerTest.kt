package com.daily.programmer.banker

import org.junit.Test

/**
 * Created by parci on 12/17/2017.
 */
class BankerTest {

    @Test
    fun processTest() {
        val banker = Banker()

        val processList : List<Process> = createProcessList()
        val availableAllocations : List<Long> = listOf(3, 3, 2)

        val resultProcessList = banker.process(processList, availableAllocations)

        System.out.println(resultProcessList)
    }

    fun createProcessList(): MutableList<Process> {
        val processList : MutableList<Process> = arrayListOf()

        var process : Process = Process()
        process.name = "P0"
        process.allocations = listOf(0, 1, 0)
        process.maxAllocations = listOf(7, 5, 3)

        processList.add(process)

        process = Process()
        process.name = "P1"
        process.allocations = listOf(2, 0, 0)
        process.maxAllocations = listOf(3, 2, 2)

        processList.add(process)

        process = Process()
        process.name = "P2"
        process.allocations = listOf(2, 0, 0)
        process.maxAllocations = listOf(3, 2, 2)

        processList.add(process)

        process = Process()
        process.name = "P3"
        process.allocations = listOf(2, 1, 1)
        process.maxAllocations = listOf(2, 2, 2)

        processList.add(process)

        process = Process()
        process.name = "P4"
        process.allocations = listOf(0, 0, 2)
        process.maxAllocations = listOf(4, 3, 3)

        processList.add(process)

        return processList
    }

}