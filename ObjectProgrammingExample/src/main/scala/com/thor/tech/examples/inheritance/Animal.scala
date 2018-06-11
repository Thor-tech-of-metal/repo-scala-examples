package com.thor.tech.examples.inheritance

/**
  * Created by @author - Thor on 21/01/16.
  */

/*** abstractions classes ***/

sealed trait Animal {

  protected def animalName:String

  /**
    * This method will be implemented to define how to walk.
    * @return how to walk
    */
  def walk:String

  /**
    * Every animal process their food in a not public way.
    * @param food the food to be eaten.
    * @return thought process result.
    */
  protected def processFood(food:String):Either[String,String]

  /**
    * This method this method defined how to eat.
    * @return eating
    */
  def eat(food:String): String= {

    val eating = processFood(food) match  {
      case Right(right) => s"${right} ${food}"
      case Left(left) => s"${left} ${food}"
    }
    println(eating)
    eating
  }

  /**
    * This method this method defined how to drink.
    * @param aDrink this is the drink to be drunk
    * @return drinking
    */
  def drink (aDrink:String):String ={

    val drinking = s"I am drinking ${aDrink}"
    println(drinking)
    drinking
  }


}

sealed trait BeingEvilFeature{

  def jutBeEvil:String
}


/*** concrete classes ***/

class Monkey(val name:String) extends Animal  {

  protected override val animalName:String ="Monkey"

  // Monkey drinking
  override def drink(drink: String): String = {
    println(s"${name}")
    super.drink(drink)
  }

  // Monkey eating
  override def eat(food: String): String = {
    println(s"${name} will try to eat")
    super.eat(food)
  }

  /**
    * Concrete implementation of a monkey walking
    * @return how to walk
    */
  override def walk: String = {

    val walking = s"${name} is walking"
    println(walking)
    walking
  }

  /**
    * Not public monkey thought process about food.
    * @param food the food to be eaten.
    * @return monkey thought result.
    */
  override protected def processFood(food: String): Either[String, String] = {

    if (food == "Mature Banana") Right(s"${animalName}  will eat the ${food}. WA WA WA !!!")
    else Left(s"${animalName}  will not eat the ${food}. WA WA WA !!!")
  }
}

final case class Person(override val name: String) extends Monkey(name = "") with BeingEvilFeature {

  protected override val animalName:String ="Person"

  override def jutBeEvil: String = {

    val beEvil = "Monkeys are not evil. However humans can be evils"
    println(beEvil)
    beEvil
  }

  /**
    * Not public person thought process about food.
    * @param food the food to be eaten.
    * @return person thought result.
    */
  override protected def processFood(food: String): Either[String, String] = {

    if (food == "Food") Right(s"${name}  will eat the ${food}. yummy yummy!!!!")
    else Left(s"${name}  will no eat the ${food}.crap!!!!")
  }
}


