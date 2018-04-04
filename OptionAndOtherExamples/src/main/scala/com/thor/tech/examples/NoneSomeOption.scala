package com.thor.tech.examples

/**
  * Created by tobias on 21/12/2016.
  */
object NoneSomeOption {

  def main(args: Array[String]): Unit = {
    test1();
    test2();
    test3();
    test4();
    test5();
  }

  def test1(): Unit ={

    println("Step 1: How to use Option and None - a basic example")
    println("The use of get can lead to NullPointerException")
    val glazedDonutTaste: Option[String] = Some("Very Tasty")
    println(s"Glazed Donut taste = ${glazedDonutTaste.get}")

  }

  def test2() : Unit= {

    println("\nStep 2: How to use Option and None - a basic example")
    println("The use of getOrElse avoid NullPointerException")
    val glazedDonutName: Option[String] = None
    println(s"Glazed Donut name = ${glazedDonutName.getOrElse("Glazed Donut")}")
  }

  def test3(): Unit ={

    println("\nStep 3: How to use Pattern Matching with Option")
    println("Patter matching is always an option")

    val glazedDonutName: Option[String] = Some("Very Tasty")

    glazedDonutName match {
      case Some(name) => println(s"Received donut name = $name")
      case None       => println(s"No donut name was found!")
    }
  }

  def test4 () : Unit= {

    println("\nTip 4: Filter all None using map function")

    val glazedDonutName: Option[String] = Some("Very Tasty")
    val glazedDonutTaste: Option[String] = None


    glazedDonutTaste.map(taste => println(s"glazedDonutTaste = $taste"))
    glazedDonutName.map(name => println(s"glazedDonutName = $name"))
  }

  def test5() :Unit = {

    println("\nTip 5: Map can make all easier")
    val opt = Option(1)

    val a = opt match {
      case Some(x) => x + 1
      case None => "a"
    }
    println(s"\nTip 5: Result without map: ${a}")
    val b = opt map (_ + 1) getOrElse "a"

    println(s"\nTip 5: Result with map: ${b}")
  }
}
