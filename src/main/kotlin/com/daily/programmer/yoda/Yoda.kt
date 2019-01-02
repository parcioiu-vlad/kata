package com.daily.programmer.yoda

import java.util.*

/**
 * A long, long time ago in a galaxy far, far away a big collision of integers is taking place right now.
 * What happens when two integers collide? During collision, each digit of one number compares itself
 * to the corresponding digit of the other number (the least significant digit with the other’s least significant digit, and so on).
 * The smaller digit “falls out” of the number containing it. Additionally, if the digits are the same, nothing happens.
 * If a number doesn’t consist of a corresponding digit, then we consider it to be zero.
 * After all comparisons of corresponding digits, the leftover digits in the number come closer and create a new number.
 */
class Yoda {

    fun process(a: String, b: String): Pair<Any, Any> {
        val listA = a.toMutableList()
        val listB = b.toMutableList()

        val sizeDiff = Math.abs(listA.size - listB.size)
        if (listA.size > listB.size) {
            addZeros(listB, sizeDiff)
        } else if (listA.size < listB.size) {
            addZeros(listA, sizeDiff)
        }

        val yodaListA: MutableList<Int> = LinkedList()
        val yodaListB: MutableList<Int> = LinkedList()

        for (i in 0 until listA.size) {
            val intA = listA[i].toString().toInt()
            val intB = listB[i].toString().toInt()

            when {
                intA > intB -> yodaListA.add(intA)
                intA < intB -> yodaListB.add(intB)
                else -> {
                    yodaListA.add(intA)
                    yodaListB.add(intB)
                }
            }
        }

        val numberA = concatValues(yodaListA)
        val numberB = concatValues(yodaListB)

        return Pair(numberA, numberB)
    }

    private fun addZeros(list: MutableList<Char>, size: Int) {
        var i = 0
        while (i < size) {
            list.add(0, '0')
            i++
        }
    }

    private fun concatValues(list: MutableList<Int>): Any {
        var n = 0

        if (list.isEmpty()) {
            return "YODA"
        }

        list.forEach { n = it + n * 10 }
        return n
    }

}

fun main(args: Array<String>) {
    val yoda = Yoda()

    val a = readLine()
    val b = readLine()

    val values = yoda.process(a!!, b!!)

    println(values.first)
    println(values.second)
}