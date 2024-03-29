package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
object Transition {
  val stateMap = Map(
    "start" -> new StartState,
    "white" -> new WhiteState,
    "red" -> new RedState,
    "black" -> new BlackState,
    "orange" -> new OrangeState,
    "green" -> new GreenState,
    "done" -> new DoneState
  )
}

