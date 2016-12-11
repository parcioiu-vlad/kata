package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class BlackState extends State {

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("black".equals(nextState) || "green".equals(nextState) || "orange".equals(nextState)) {
      return Transition.stateMap(nextState)
    }

    null
  }

  override def name(): String = {
    "black"
  }
}
