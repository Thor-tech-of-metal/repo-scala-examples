package com.thor.tech.examples.variance.contravariant.model

sealed trait Item {
  def itemName: String

  def printDrinkName()={ println(s"This is the item name ${itemName}")
  }


  override def toString = s"Item($itemName)"
}

/** Plastic **/
class PlasticItem(override val itemName: String) extends Item

class PlasticBottle(override val itemName: String) extends PlasticItem(itemName = "")

class SpecailPlasticBottle(override val itemName: String) extends PlasticItem(itemName = "")

case class PlasticBottleNotRecyclable(override val itemName: String) extends PlasticBottle(itemName = "")


/** Papper **/
class PaperItem(override val itemName: String) extends Item

case class NewsPaper(override val itemName: String) extends PaperItem(itemName = "")

