package com.daily.programmer.patternlook

/**
  * You will be given a sequence that of letters and you must match with a dictionary.
  * The sequence is a pattern of equal letters that you must find.
  *
  * E.G.
  * Pattern:
  * XXYY means that you have a word that contains a sequence of 2 of the same letters followed by again 2 of the same letters
  *
  * succeed <- matches
  * succes <- no match
  *
  * XYYX means we have a word with at least for letters where you have a sequence of a letter, followed by 2 letters that are the same and then again the first letter
  *
  * narrate <- matches
  * hodor <- no match
  */
class PatternLook {

    /**
      * Maintains a pseudo machine state 'statedMap' for regex (https://swtch.com/~rsc/regexp/regexp1.html).
      *
      * @param word
      * @param pattern
      */
    def isMatch(word: String, pattern: String): Boolean = {

        var statedMap = Map[Char, Char]()
        var currentStateNo = 0
        var wordIndex = 0

        while (wordIndex < word.toCharArray.length) {

            if (!statedMap.contains(pattern.charAt(currentStateNo))) {
                statedMap += pattern.charAt(currentStateNo) -> word.charAt(wordIndex)
                currentStateNo += 1
            }
            else if (statedMap(pattern.charAt(currentStateNo)).equals(word.charAt(wordIndex))) {
                currentStateNo += 1
            }
            else {
                statedMap = Map()
                currentStateNo = 0
                wordIndex -= 1
            }

            if (currentStateNo > pattern.length() - 1) {
                return true
            }

            wordIndex += 1
        }

        false
    }

}
