package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class RedState extends State{

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if (!"green".equals(nextState)) {
      return null
    }

    Transition.stateMap(nextState)
  }

}
