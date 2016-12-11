package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class StateContext {

  private var _nextState : String = _

  private val _stateMap = Map(
    "start" -> new StartState,
    "white" -> new WhiteState,
    "red" -> new RedState,
    "black" -> new BlackState,
    "orange" -> new OrangeState,
    "green" -> new GreenState,
    "done" -> new DoneState
  )

  def nextState(): String = {
    _nextState
  }

  def nextState_(nextState : String) {
    _nextState = nextState
  }

  def stateMap(): Unit = {
    _stateMap
  }

}
