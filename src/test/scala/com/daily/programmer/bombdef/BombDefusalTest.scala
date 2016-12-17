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
    var wires = List("white",
      "white",
      "red",
      "white",
      "orange",
      "black",
      "black",
      "green",
      "orange")

    Assert.assertEquals("Bomb defused", bombDefusal.defuse(wires))

    wires = List(
      "white",
      "white",
      "red",
      "red",
      "red",
      "white",
      "white",
      "black",
      "green",
      "orange"
    )

    Assert.assertEquals("Bomb defused", bombDefusal.defuse(wires))
  }

  /**
    * Should go BOOM
    */
  @Test
  def goesBoom(): Unit = {
    var wires = List(
        "white",
        "white",
        "green",
        "orange",
        "green"
    )

    Assert.assertEquals("Boom", bombDefusal.defuse(wires))

    wires = List(
        "black",
        "green",
        "green"
    )

    Assert.assertEquals("Boom", bombDefusal.defuse(wires))
  }

  @Test
  def canBeDefused(): Unit = {
    val wireMap = Map(
      "white" -> 4,
      "red" -> 3,
      "black" -> 4,
      "green" -> 1,
      "orange" -> 1
    )

    Assert.assertEquals(true, bombDefusal.canBeDefusedDFS(wireMap))
  }

  @Test
  def cannotBeDefused(): Unit = {
    val wireMap = Map(
      "white" -> 4,
      "red" -> 3,
      "black" -> 4,
      "green" -> 0,
      "orange" -> 1
    )

    Assert.assertEquals(false, bombDefusal.canBeDefusedDFS(wireMap))
  }

}
