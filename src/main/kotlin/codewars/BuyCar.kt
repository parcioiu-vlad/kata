package codewars

import kotlin.math.roundToInt

/**
 * https://www.codewars.com/kata/554a44516729e4d80b000012
 *
 * A man has a rather old car being worth $2000. He saw a secondhand car being worth $8000. He wants to keep his old car until he can buy the secondhand one.
 * He thinks he can save $1000 each month but the prices of his old car and of the new one decrease of 1.5 percent per month.
 * Furthermore this percent of loss increases of 0.5 percent at the end of every two months.
 * Our man finds it difficult to make all these calculations.
 *
 * nbMonths(2000, 8000, 1000, 1.5) should return [6, 766] or (6, 766)
 *
 * month 1: 2000	8000	1000	1970	7880	4910       (percentLossByMonth 1.5)
 * month 2: 1970	7880	2000	1930,6	7722,4	3791,8     (percentLossByMonth 2)
 * ...
 *
 */
object BuyCar {
    fun nbMonths(
        startPriceOld: Int,
        startPriceNew: Int,
        savingperMonth: Int,
        percentLossByMonth: Double
    ): Pair<Int, Int> {

        var month = 1
        var saving = savingperMonth
        var percentage = percentLossByMonth
        var priceOld = startPriceOld.toDouble()
        var priceNew = startPriceNew.toDouble()
        var remainingMoney = priceOld - priceNew

        while (remainingMoney < 0) {
            priceOld -= percentage / 100 * priceOld
            priceNew -= percentage / 100 * priceNew
            remainingMoney = priceOld - priceNew + saving
            saving += savingperMonth

            month++

            if (month % 2 == 0) {
                percentage += 0.5
            }
        }

        return Pair(month - 1, remainingMoney.roundToInt())
    }
}
