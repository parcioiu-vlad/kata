package com.daily.programmer.banker

/**
 * Created by parci on 12/17/2017.
 */
class Process {

    var name: String = ""
    var allocations: List<Long> = arrayListOf()
    var maxAllocations: List<Long> = arrayListOf()

    fun getNoAllocations() : Long {
        return allocations.stream().mapToLong { v -> v }.sum()
    }

    fun getNoMaxAllocations() : Long {
        return maxAllocations.stream().mapToLong { v -> v }.sum();
    }
}