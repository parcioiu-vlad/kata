package com.daily.programmer.kaprekar

import org.slf4j.LoggerFactory

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square
  * in that base can be split into two parts that add up to the original number again. For instance,
  * 45 is a Kaprekar number, because 45^2 = 2025 and 20+25 = 45.
  */
class Kaprekar {

  private val LOG = LoggerFactory.getLogger(classOf[Kaprekar])

  /**
    * Return a list of Kaprekar numbers between interval
    * @param leftInterval left side of the interval
    * @param rightInterval right side of the interval
    * @return list of kaprekar numbers
    */
  def getKaprekarNumbers(leftInterval: Long, rightInterval: Long) : mutable.Buffer[Double] = {
    //TODO check for negative numbers

    var kaprekarNumbers = new ArrayBuffer[Double]

    if (leftInterval == 1) {
      kaprekarNumbers += 1
    }

    for (number <- leftInterval to rightInterval) {

      val numberSquare = scala.math.pow(number, 2)
      val numbers = splitNumber(numberSquare.toLong)

      if (numbers._2 != 0) {
        //e.g 10 !kaprekar
        if (numbers._1 + numbers._2 == number) {
          LOG.debug("Number " + number + " is Kaprekar " + numberSquare + " = " + numbers._1 + " + " + numbers._2)
          kaprekarNumbers += number
        }
        else if (numbers._3 + numbers._4 == number) {
          LOG.debug("Number " + number + " is Kaprekar " + numberSquare + " = " + numbers._3 + " + " + numbers._4)
          kaprekarNumbers += number
        }
      }
    }

    kaprekarNumbers
  }

  def splitNumber(number: Long) : (Long, Long, Long, Long) = {
    val numberOfDigits = getNumberDigits(number, 1)

    var left : Long = 0
    var right : Long = 0
    var leftOdd : Long = 0
    var rightOdd : Long = 0

    if (numberOfDigits % 2 == 0) {
      left = number / scala.math.pow(10, numberOfDigits / 2).toLong
      right = number % scala.math.pow(10, numberOfDigits / 2).toLong

      (left, right, leftOdd, rightOdd)
    }
    else {
      left = number.toString.substring(0, numberOfDigits / 2 + 1).toLong
      if (numberOfDigits > 1) {
        right = number.toString.substring(numberOfDigits / 2 + 1).toLong

        leftOdd = number.toString.substring(0, numberOfDigits / 2).toLong
        rightOdd =  number.toString.substring(numberOfDigits / 2).toLong
      }

      (left, right, leftOdd, rightOdd)
    }
  }

  def getNumberDigits(number: Double, digitNo: Int): Int = {
    if (number < 10) {
      digitNo
    }
    else {
      getNumberDigits(number / 10, digitNo + 1)
    }
  }
}