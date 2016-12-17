package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class GreenState extends State {

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("orange".equals(nextState)) {
      return Transition.stateMap("done")
    }

    null
  }

  override def name(): String = {
    "green"
  }

  override def getNextPossibleStateNames(): List[String] = {
    List[String]("orange")
  }
}
