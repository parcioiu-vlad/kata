package com.daily.programmer.bombdef

import com.daily.programmer.bombdef.state._
import org.slf4j.LoggerFactory

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  *
  * To disarm the bomb you have to cut some wires. These wires are either white, black, purple, red, green or orange.
  * The rules for disarming are simple:
  *   If you cut a white cable you can't cut white or black cable.
  *   If you cut a red cable you have to cut a green one
  *   If you cut a black cable it is not allowed to cut a white, green or orange one
  *   If you cut a orange cable you should cut a red or black one
  *   If you cut a green one you have to cut a orange or white one
  *   If you cut a purple cable you can't cut a purple, green, orange or white cable
  *   If you have anything wrong in the wrong order, the bomb will explode.
  * There can be multiple wires with the same colour and these instructions are for one wire at a time.
  * Once you cut a wire you can forget about the previous ones.
  */
class BombDefusal {

  private val LOG = LoggerFactory.getLogger(classOf[BombDefusal])

  def defuse(wires : List[String]): String = {

    if (wires == null || wires.isEmpty) {
      LOG.warn("No wires input")
      return null
    }

    var state : State = Transition.stateMap(wires.head)

    for (wire <- wires.drop(1)) {
      if (state == null) {
        LOG.info("Boom!")
        return "Boom"
      }

      state = cutWire(state, wire)
    }

    LOG.info("Bomb defused")
    "Bomb defused"

  }

  def cutWire(state : State, wire : String): State = {
    LOG.info("Cutting " + wire + " wire")
    state.cut(wire)
  }

}
