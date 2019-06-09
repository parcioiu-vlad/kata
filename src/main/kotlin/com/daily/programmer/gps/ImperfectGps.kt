package com.daily.programmer.gps

/**
 * https://open.kattis.com/problems/imperfectgps
 */
class ImperfectGps {

    fun calculateDistance(measurementList: List<Measurement>): Double {
        var distance = 0.0

        var prev = measurementList.first()
        val iterator = measurementList.listIterator()

        while (iterator.hasNext()) {
            val next = iterator.next()
            distance += Math.sqrt(Math.pow((next.point.x - prev.point.x).toDouble(), 2.0)
                    + Math.pow((next.point.y - prev.point.y).toDouble(), 2.0))

            prev = next
        }

        return distance
    }

    fun calculatePrecision(measurementList: List<Measurement>,
                           gpsTimeStep: Int): List<Measurement> {

        val gpsMeasurementList: MutableList<Measurement> = ArrayList()

        gpsMeasurementList.add(measurementList.first())

        var gpsTime = gpsTimeStep

        while (gpsTime < measurementList.last().time) {
            val measurementPair = findPair(measurementList, gpsTime)
            val firstMeasurement = measurementPair.first
            val secondMeasurement = measurementPair.second

            val gpsPoint = calculateGpsPosition(firstMeasurement, secondMeasurement, gpsTime)


            gpsMeasurementList.add(Measurement(gpsPoint, gpsTime))

            gpsTime += gpsTimeStep
        }

        gpsMeasurementList.add(measurementList.last())

        return gpsMeasurementList
    }

    private fun findPair(measurementList: List<Measurement>,
                         time: Int): Pair<Measurement, Measurement> {

        var measurement = measurementList.first()
        var curr = measurementList.first()
        val iterator = measurementList.listIterator()
        while (iterator.hasNext()) {
            curr = iterator.next()
            if (curr.time > time) {
                return Pair(measurement, curr)
            }
            measurement = curr
        }

        return Pair(measurement, curr)
    }

    private fun calculateGpsPosition(firstMeasurement: Measurement,
                                     secondMeasurement: Measurement,
                                     gpsTime: Int): Point {

        val timeDiff = secondMeasurement.time - gpsTime

        val xVectorDirection = getVectorDirection(firstMeasurement.point.x, secondMeasurement.point.x)
        val gpsX = secondMeasurement.point.x + xVectorDirection * timeDiff


        val yVectorDirection = getVectorDirection(firstMeasurement.point.y, secondMeasurement.point.y)
        val gpsY = secondMeasurement.point.y + yVectorDirection * timeDiff

        return Point(gpsX, gpsY)

    }

    private fun getVectorDirection(x: Int, y: Int): Int {
        return when {
            x == y -> 0
            x < y -> -1
            else -> 1
        }
    }

    fun main(args: Array<String>) {
        var values = readLine()!!.split("\\s".toRegex())
        val numberOfMeasurements = Integer.parseInt(values[0])
        val gpsTimeStep = Integer.parseInt(values[1])

        val measurementList = ArrayList<Measurement>()
        for (i in 0 until numberOfMeasurements) {
            values = readLine()!!.split("\\s".toRegex())
            val x = Integer.parseInt(values[0])
            val y = Integer.parseInt(values[1])
            val time = Integer.parseInt(values[2])
            measurementList.add(Measurement(Point(x, y), time))
        }

        val imperfectGps = ImperfectGps()
        val gpsMeasurementList = imperfectGps.calculatePrecision(measurementList, gpsTimeStep)

        val measurementDistance = imperfectGps.calculateDistance(measurementList)
        val gpsDistance = imperfectGps.calculateDistance(gpsMeasurementList)

        println((measurementDistance - gpsDistance) / measurementDistance * 100)
    }

}
