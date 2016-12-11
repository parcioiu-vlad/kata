package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class RedState extends State{

  override def cut(nextState: String): State = {
    if (nextState == null) {
      return null
    }

    if ("red".equals(nextState)) {
      return Transition.stateMap("start")

    } else  if ("black".equals(nextState)) {
      return Transition.stateMap("black")
    }

    null
  }

  override def name(): String = {
    "red"
  }

}
