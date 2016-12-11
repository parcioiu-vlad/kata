package com.daily.programmer.bombdef.state

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class DoneState extends State {

  override def cut(nextState: String): State = {
    this
  }

  override def name(): String = {
    "done"
  }

}
