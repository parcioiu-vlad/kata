package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class OrangeState extends State{

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("green".equals(nextState)) {
      return Transition.stateMap("done")
    }

    null

  }

  override def name(): String = {
    "orange"
  }

  override def getNextPossibleStateNames(): List[String] = {
    List[String]("green")
  }
}
