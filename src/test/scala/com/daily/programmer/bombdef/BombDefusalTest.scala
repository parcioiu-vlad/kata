package com.daily.programmer.bombdef

import org.junit.{Assert, Test}

/**
  * Created by Vlad-Alexandru.PIRCI on 12/11/2016.
  */
class BombDefusalTest {

  val bombDefusal = new BombDefusal

  /**
    * Should defuse bomb
    */
  @Test
  def defuseBomb(): Unit = {
    val wires = List("white", "red", "green", "white")

    Assert.assertEquals("Bomb defused", bombDefusal.defuse(wires))
  }

  /**
    * Should go BOOM
    */
  @Test
  def goesBoom(): Unit = {
    val wires = List("white", "orange", "green", "white")

    Assert.assertEquals("Boom", bombDefusal.defuse(wires))
  }

}
