package com.daily.programmer.patternlook

import org.junit.{Test}

import scala.io.Source

/**
  * Created by Vlad-Alexandru.PIRCI on 2/4/2017.
  */
class PatternLookTest {

    @Test
    def testPatern(): Unit = {
        val patternLook = new PatternLook
        val pattern = "XXYYX"

        val readmeText : Iterator[String] = Source.fromResource("dictionary").getLines
        readmeText.foreach(line => {
            if (patternLook.isMatch(line, pattern))
                System.out.println(line)
        })
    }

}
