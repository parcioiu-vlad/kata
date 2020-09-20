package com.daily.programmer.util

import scala.collection.mutable
import scala.io.Source

/**
  * Created by vlad on 3/16/2017.
  */
class ScalaDictionaryFileUtil {

  def getWordSet(): mutable.Set[String] = {
    var wordSet = new mutable.HashSet[String]()

    val readmeText : Iterator[String] = Source.fromResource("dictionary").getLines
    readmeText.foreach(line => {
      wordSet += line
    })

    wordSet
  }

}
