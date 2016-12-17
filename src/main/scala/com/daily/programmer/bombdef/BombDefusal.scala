package com.daily.programmer.bombdef

import com.daily.programmer.bombdef.state._
import org.slf4j.LoggerFactory

import scala.collection.mutable
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

  /**
    * Check if the wires list can defuse the bomb
    *
    * @param wires list of wire names, the order specifies the cutting order
    * @return 'Boom' cutting order was wrong, 'Bomb defused' if the cutting order was correct
    */
  def defuse(wires: List[String]): String = {

    if (wires == null || wires.isEmpty) {
      LOG.warn("No wires input")
      return null
    }

    var state: State = Transition.stateMap("start")

    for (wire <- wires) {
      if (state == null) {
        return boom()
      } else if (state.name().equals("done")) {
        return "Bomb defused"
      }

      state = cutWire(state, wire)
    }

    if (state != null && state.name().equals("done")) {
      "Bomb defused"
    } else {
      boom()
    }

  }

  /**
    * Check that the provided wire map can be defused
    *
    * @param wireMap map containg how many wires there are, e.g. ("white" -> 4,"red" -> 3) means that there are 4 white wires and
    *                3 red wires
    * @return true if the bomb can be defused, false otherwise
    */
  def canBeDefusedDFS(wireMap: Map[String, Int]): Boolean = {
    val mWireMap = collection.mutable.Map() ++ wireMap

    case class Wire(var name: String)
    val wireStack = mutable.Stack[String]()

    var state: State = Transition.stateMap("start")

    wireStack.push("start")

    while (wireStack.nonEmpty) {

      if (state.name().equals("done")) {
        LOG.info("Wire list " + wireStack.toList + " is defusable")
        return true
      }

      val possibleStates = state.getNextPossibleStateNames()
      val nextWire = hasNext(possibleStates, mWireMap)

      if (nextWire == null) {
        val wireFromStack = wireStack.pop()

        if (wireFromStack.equals("start")) {
          return false
        }

        val noStates = mWireMap(wireFromStack)
        mWireMap.update(wireFromStack, noStates - 1)

      } else {
        val noStates = mWireMap(nextWire)
        mWireMap(nextWire) = noStates - 1
        wireStack.push(nextWire)
        state = cutWire(state, nextWire)
      }
    }
    false
  }

  def hasNext(possibleStates: List[String], wireMap: mutable.Map[String, Int]): String = {
    for (wire <- possibleStates) {
      if (wireMap.get(wire) != null && wireMap(wire) > 0) {
        return wire
      }
    }
    null
  }

  def cutWire(state: State, wire: String): State = {
    LOG.info("Cutting " + wire + " wire")
    state.cut(wire)
  }

  def boom(): String = {
    LOG.debug("Boom!")
    "Boom"
  }

}
