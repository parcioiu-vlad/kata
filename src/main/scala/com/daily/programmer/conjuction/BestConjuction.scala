package com.daily.programmer.conjuction

import com.daily.programmer.util.DictionaryFileUtil
import org.slf4j.LoggerFactory

import scala.collection.mutable.ListBuffer

/**
  * Your job is to find the best conjunction—
  * that is, find the word with the most sub-words inside of it given a list of English words.
  * Some example include:
  *   Something (3 words: So, me, thing)
  *   Awesomeness (3 words: awe, some, ness)
  */
class BestConjuction {

  private val LOG = LoggerFactory.getLogger(classOf[BestConjuction])

  def getConjuctions(word: String, minSize: Int): List[String] = {
    var words = new ListBuffer[String]
    val dictionary = new DictionaryFileUtil

    getWords(word, minSize).foreach(subWord => {
      if (dictionary.getWordSet().apply(subWord)) {
        words += subWord
      }
    })

    words.toList
  }

  def getWords(word: String, minSize: Int): List[String] = {
    if (word.length < minSize) {
      LOG.warn("BestConjuction -> getWords - word length smaller than minSize")
      return List.empty
    }

    var i = 0
    var words = new ListBuffer[String]

    for (i <- 0 to word.length - minSize) {
      words += word.substring(i, i + minSize)
    }

    words.toList
  }

}
