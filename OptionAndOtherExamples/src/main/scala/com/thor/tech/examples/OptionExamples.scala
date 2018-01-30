package com.thor.tech.examples

object OptionExamples {


  def mostIdiomaticExample(number: Int): String = {

    val opt = if (number == 0) None else Option(number)
    val result = opt map (_ + 1) getOrElse "nothing it was zero! WA"
    result.toString
  }


  def mostIdiomaticExampleWhichIgnoreNone(number: Int): String = {

    val opt = if (number == 0) None else Option(number)

    opt flatMap (element => Option(element + 1) ) match {
      case None => "nothing it was zero! WA"
      case Some(number) => number.toString
    }
  }

}
