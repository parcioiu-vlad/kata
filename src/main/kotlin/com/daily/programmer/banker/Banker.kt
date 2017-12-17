package com.daily.programmer.banker

/**
 * Created by parci on 12/17/2017.
 *
 * Create a program that will solve the banker’s algorithm.
 * This algorithm stops deadlocks from happening by not allowing processes to start if they don’t have access to the resources necessary to finish.
 * A process is allocated certain resources from the start, and there are other available resources.
 * In order for the process to end, it has to have the maximum resources in each slot.
 */
class Banker {

    fun process(processList: List<Process>, availableAllocations: List<Long>): List<Process> {
        val sortedProcessList = processList.sortedWith(compareBy({it.getNoMaxAllocations()}))
        val availableAllocationList = ArrayList(availableAllocations)

        val availableNoAllocationSum = availableAllocations.stream().mapToLong { v -> v }.sum()

        for (proc in sortedProcessList) {
            if (proc.getNoAllocations() + proc.getNoMaxAllocations() < availableNoAllocationSum) {
                return emptyList()
            }

            for (i in availableAllocationList.indices) {
                val sum = availableAllocationList.get(i) + proc.allocations.get(i)
                if (sum < proc.maxAllocations.get(i)) {
                    return emptyList()
                }

                availableAllocationList.set(i, sum)
            }
        }

        return sortedProcessList
    }

}
