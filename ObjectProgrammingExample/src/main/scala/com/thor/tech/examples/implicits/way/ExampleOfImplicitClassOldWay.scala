package com.thor.tech.examples.implicits.way

/**
  * Created by tobias on 01/02/2017.
  */


class StringImprovementsImpl ( val string: String ) {

  def increment = string.map( character => (character + 1).toChar )
}




/**
  * Created by tobias on 01/02/2017.
  */
object ExampleOfImplicitClassOldWay {

  implicit def stringToString(s: String) = new StringImprovementsImpl(s)

  def main(args:Array[String]):Unit = {

    println("inspor".increment)
  }
}