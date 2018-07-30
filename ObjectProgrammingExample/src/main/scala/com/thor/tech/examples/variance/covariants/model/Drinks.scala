package com.thor.tech.examples.variance.covariants.model

sealed trait Drinks {
  def drinkName: String

  def printDrinkName()={ println(s"This is the drink name ${drinkName}")
  }
}

/** SoftDrinks **/
class SoftDrink(override val drinkName: String) extends Drinks

case class Cola(override val drinkName: String) extends SoftDrink(drinkName = "")

case class TonicWater(override val drinkName: String) extends SoftDrink(drinkName = "")

/** Juices **/
class Juice(override val drinkName: String) extends Drinks

case class Orange(override val drinkName: String) extends Juice(drinkName = "")

case class Apple(override val drinkName: String) extends Juice(drinkName = "")
