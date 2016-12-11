package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class StartState extends State {

  override def cut(nextState: String): State = {

    if (nextState == null) {
      return null
    }

    if ("white".equals(nextState)) {
      return Transition.stateMap(nextState)
    } else if ("red".equals(nextState)) {
      return Transition.stateMap(nextState)
    }

    null

  }

  override def name(): String = {
    "start"
  }

}
