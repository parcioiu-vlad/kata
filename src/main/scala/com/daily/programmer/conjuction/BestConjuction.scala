package com.daily.programmer.conjuction

import com.daily.programmer.util.DictionaryFileUtil
import org.slf4j.LoggerFactory

import scala.collection.mutable.ListBuffer

/**
  * Your job is to find the best conjunction—
  * that is, find the word with the most sub-words inside of it given a list of English words.
  * Some example include:
  * Something (3 words: So, me, thing)
  * Awesomeness (3 words: awe, some, ness)
  *
  * Bonus:
  *     Instead of simply the last letter, allow any number of letters to be shared between words
  *     (e.g. consciencestricken => conscience, sciences, stricken
  */
class BestConjuction {

    private val LOG = LoggerFactory.getLogger(classOf[BestConjuction])

    private  val dictionary = new DictionaryFileUtil

    def getConjuctions(word: String, minSize: Int): List[String] = {
        if (word.length < minSize) {
            LOG.warn("BestConjuction -> getWords - word length smaller than minSize")
            return List.empty
        }

        var words = new ListBuffer[String]
        var i = 0
        var j = ""

        for (i <- minSize until word.length - 1) {
            for (j <- word.sliding(i)) {
                if (wordExists(j)) {
                    words += j
                }
            }
        }

        words.toList
    }

    private def wordExists(word: String): Boolean = {
        dictionary.getWordSet().apply(word)
    }
}
