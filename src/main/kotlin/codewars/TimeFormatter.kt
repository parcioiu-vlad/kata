package codewars

/**
 * https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/kotlin
 *
 * The function must accept a non-negative integer. If it is zero, it just returns "now".
 * Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 */
object TimeFormatterKata {

    fun formatDuration(seconds: Int): String {
        if (seconds == 0) {
            return "now"
        }

        val timeList = listOfNotNull(
            toString(seconds / 31536000, "year"),
            toString(seconds % 31536000 / 86400, "day"),
            toString(seconds % 86400 / 3600, "hour"),
            toString(seconds % 3600 / 60, "minute"),
            toString(seconds % 60, "second")
        ).toList()

        if (timeList.size == 1) {
            return timeList[0]
        }

        if (timeList.size == 2) {
            return timeList[0] + " and " + timeList[1]
        }

        return timeList.subList(0, timeList.size - 1)
            .joinToString(", ") + " and " + timeList[timeList.size - 1]
    }

    fun toString(time: Int, period: String): String? {
        return when (time) {
            0 -> {
                null
            }
            1 -> {
                "1 $period"
            }
            else -> {
                "$time ${period}s"
            }
        }
    }

}
