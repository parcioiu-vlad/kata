package com.daily.programmer.smalpha

import java.util.*

/**
 * https://old.reddit.com/r/dailyprogrammer/comments/cn6gz5/20190807_challenge_380_intermediate_smooshed/
 *
 * A permutation of the alphabet is a 26-character string in which each of the letters a through z appears once.
 *
 * Given a smooshed Morse code encoding of a permutation of the alphabet, find the permutation
 * it encodes, or any other permutation that produces the same encoding
 */
class SmooshedMorse {

    companion object {
        val morseMap = mapOf(".-" to "a",
                "-..." to "b",
                "-.-." to "c",
                "-.." to "d",
                "." to "e",
                "..-." to "f",
                "--." to "g",
                "...." to "h",
                ".." to "i",
                ".---" to "j",
                "-.-" to "k",
                ".-.." to "l",
                "--" to "m",
                "-." to "n",
                "---" to "o",
                ".--." to "p",
                "--.-" to "q",
                ".-." to "r",
                "..." to "s",
                "-" to "t",
                "..-" to "u",
                "...-" to "v",
                ".--" to "w",
                "-..-" to "x",
                "-.--" to "y",
                "--.." to "z")
    }

    /**
     *
     * @param code morse code
     * @return list of all possible permutations
     */
    fun smalpha(code: String): MutableList<String> {
        //TODO simplify function
        //TODO add threads (?one per permutation, e.g. spawn 4 threads?)
        val codeList = mutableListOf<String>()

        //used to backtrack
        val stack = Stack<Morse>()

        if (code.length <= 4) {
            return codeList
        }

        //add to stack all possible permutations from the first 4 characters
        for (i in 1..4) {
            stack.push(Morse(i, getLetter(0, i, code)))
        }

        while (!stack.empty()) {
            val morse = stack.pop()

            if (morse.codeIndex == code.length) {
                codeList.add(morse.code)
                continue
            }

            if (morse.codeIndex > code.length) {
                continue
            }

            //add to stack the next possible permutations from the next 4 characters
            for (i in 1..4) {
                val index = morse.codeIndex
                val end = index + i

                if (end > code.length) {
                    continue
                }

                val letter = getLetter(index, end, code)
                if (morse.code.contains(letter)) {
                    continue
                }
                stack.push(Morse(end, morse.code + letter))
            }

        }

        return codeList
    }

    private fun getLetter(index: Int, end: Int, code: String): String {
        return morseMap[code.substring(index, end)].orEmpty()
    }

}
