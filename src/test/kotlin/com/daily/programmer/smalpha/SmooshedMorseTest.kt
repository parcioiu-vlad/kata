package com.daily.programmer.smalpha

import org.junit.Assert
import org.junit.Test

class SmooshedMorseTest {

    @Test
    fun processTest() {
        val smooshedMorse = SmooshedMorse()

        val codeList = smooshedMorse.smalpha(".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..")

        println(codeList)

        Assert.assertTrue(codeList.contains("wirnbfzehatqlojpgcvusyxkmd"))
    }

}
