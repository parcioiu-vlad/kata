package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class WhiteState extends State{

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("white".equals(nextState) || "black".equals(nextState)) {
      return null
    }

    Transition.stateMap(nextState)

  }
}
