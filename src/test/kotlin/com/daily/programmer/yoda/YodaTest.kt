package com.daily.programmer.yoda

import org.junit.Assert
import org.junit.Test

class YodaTest {

    @Test
    fun processTest() {
        val yoda = Yoda()

        var result = yoda.process("300", "500")
        Assert.assertEquals("0", result.first.toString())
        Assert.assertEquals("500", result.second.toString())

        result = yoda.process("65743", "9651")
        Assert.assertEquals("673", result.first.toString())
        Assert.assertEquals("95", result.second.toString())

        result = yoda.process("2341", "6785")
        Assert.assertEquals("YODA", result.first.toString())
        Assert.assertEquals("6785", result.second.toString())
    }

}