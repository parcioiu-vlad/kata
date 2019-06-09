package com.daily.programmer.gps

import org.junit.Assert
import org.junit.Test

class ImperfectGpsTest {

    @Test
    fun processTest() {
        val imperfectGps = ImperfectGps()

        val measurementList: MutableList<Measurement> = ArrayList()
        measurementList.add(Measurement(Point(0, 0), 0))
        measurementList.add(Measurement(Point(0, 3), 3))
        measurementList.add(Measurement(Point(-2, 5), 5))
        measurementList.add(Measurement(Point(0, 7), 7))
        measurementList.add(Measurement(Point(2, 5), 9))
        measurementList.add(Measurement(Point(0, 3), 11))

        val gpsMeasurementList = imperfectGps.calculatePrecision(measurementList, 2)

        val measurementDistance = imperfectGps.calculateDistance(measurementList)
        val gpsDistance = imperfectGps.calculateDistance(gpsMeasurementList)

        Assert.assertEquals(14.31, measurementDistance, 0.01)
        Assert.assertEquals(11.65, gpsDistance, 0.01)
    }
}
