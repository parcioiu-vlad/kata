package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class WhiteState extends State{

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("white".equals(nextState)) {
      return Transition.stateMap("red")
    } else if ("orange".equals(nextState)) {
      return Transition.stateMap("black")
    }

    null
  }

  override def name(): String = {
    "start"
  }
}
