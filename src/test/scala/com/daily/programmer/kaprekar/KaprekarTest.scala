package com.daily.programmer.kaprekar

import org.junit.{Assert, Before, Test}
import org.slf4j.LoggerFactory

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Vlad-Alexandru.PIRCI on 11/1/2016.
  */
class KaprekarTest {

  private val LOG = LoggerFactory.getLogger(classOf[KaprekarTest])

  var kaprekar = new Kaprekar

  @Before
  def init() {

  }

  @Test
  def getKaprekarNumbersTest(): Unit = {
    val numbers = ArrayBuffer(1.0, 9.0, 45.0, 55.0, 99.0, 297.0, 703.0, 999.0)

    val kaprekarNumbers = kaprekar.getKaprekarNumbers(1, 1000)
    LOG.info(kaprekarNumbers.toString())
    Assert.assertEquals(numbers.toString(), kaprekarNumbers.toString())
  }

  @Test
  def splitNumberTest() {
    LOG.info("Kaprekar -> test for splitting even number")

    var numbers = kaprekar.splitNumber(2025)
    LOG.info("Splitting number 2025 = " + numbers)
    Assert.assertEquals(20, numbers._1)
    Assert.assertEquals(25, numbers._2)

    numbers = kaprekar.splitNumber(12)
    LOG.info("Splitting number 12 = " + numbers)
    Assert.assertEquals(1, numbers._1)
    Assert.assertEquals(2, numbers._2)

    LOG.info("Kaprekar -> test for splitting odd number")
    numbers = kaprekar.splitNumber(123)
    LOG.info("Splitting number 123 = " + numbers)

    LOG.info("Kaprekar -> test for splitting odd number")
    numbers = kaprekar.splitNumber(12345)
    LOG.info("Splitting number 12345 = " + numbers)
  }

  @Test
  def getNumberDigitsTest() {
    val numberOfDigits = kaprekar.getNumberDigits(123, 1)
    Assert.assertEquals(numberOfDigits, 3)
  }

}
