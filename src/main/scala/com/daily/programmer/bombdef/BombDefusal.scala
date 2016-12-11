package com.daily.programmer.bombdef

import com.daily.programmer.bombdef.state._
import org.slf4j.LoggerFactory

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  *
  * You have to start with either with a white or a red wire.
  * If you picked white wire you can either pick another white wire again or you can take an orange one.
  * If you picked a red wire you have the choice between a black and red wire.
  * When a second red wire is picked, you can start from rule one again.
  * Back to the second rule, if you picked another white one you will have to pick a black or red one now
  * When the red wire is picked, you again go to rule one.
  * On the other hand if you then picked an orange wire, you can choose between green, orange and black.
  * When you are at the point where you can choose between green, orange and black and you pick either green or orange you have to choose the other one and then the bomb is defused.
  * If you ever pick a black wire you will be at the point where you have to choose between green, orange and black
  */
class BombDefusal {

  private val LOG = LoggerFactory.getLogger(classOf[BombDefusal])

  def defuse(wires : List[String]): String = {

    if (wires == null || wires.isEmpty) {
      LOG.warn("No wires input")
      return null
    }

    var state : State = Transition.stateMap("start")

    for (wire <- wires) {
      if (state == null) {
        return boom()
      } else if (state.name().equals("done")) {
        return "Bomb defused"
      }

      state = cutWire(state, wire)
    }

    if (state!= null && state.name().equals("done")) {
      "Bomb defused"
    } else {
      boom()
    }

  }

  def canBeDefused(wireMap: Map[String, Int]): Boolean = {
    //TODO improve
    //TODO split in threads | use StateContext to pass the stateMap for threads
    var wireList = new ArrayBuffer[String]

    for (key <- wireMap.keySet) {
      for (i <- 1 to wireMap(key)) {
        wireList += key
      }
    }

    LOG.info("Wire list : " + wireList)

    val wireListPermutations = wireList.permutations

    for(wires <- wireListPermutations) {
      val result = defuse(wires.toList)
      if ( "Bomb defused".equals(result)) {
        LOG.info("Wire list " + wires.toList + " is defusable")
        return true
      }
    }

    false
  }

  def cutWire(state : State, wire : String): State = {
    LOG.info("Cutting " + wire + " wire")
    state.cut(wire)
  }

  def boom(): String = {
    LOG.debug("Boom!")
    "Boom"
  }

}
