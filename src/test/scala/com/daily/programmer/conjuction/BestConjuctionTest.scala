package com.daily.programmer.conjuction

import org.junit.{Assert, Test}
import org.slf4j.LoggerFactory

/**
  * Created by vlad on 3/16/2017.
  */
class BestConjuctionTest {

    private val LOG = LoggerFactory.getLogger(classOf[BestConjuctionTest])

    val bestConjuction = new BestConjuction

    @Test
    def getConjuctionsTest(): Unit = {
        //    val word = "disproportionateness"
        var word = "disinterestedness"

        val conjuctions: List[String] = bestConjuction.getConjuctions(word, 8)

        LOG.debug("BestConjuctionTest -> getConjuctionsTest - got " + conjuctions.toString())

        Assert.assertEquals(7, conjuctions.size)
    }

}
