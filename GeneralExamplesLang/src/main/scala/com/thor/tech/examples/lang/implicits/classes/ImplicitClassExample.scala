package com.thor.tech.examples.lang.implicits.classes

import com.thor.tech.examples.lang.implicits.classes.utils.StringImprovements._


/**
  * Created by tobias on 01/02/2017.
  */

object ImplicitClassExample {

  def main(args:Array[String]):Unit = {

    println("inspor".increment)
    println("1".plusOne)
    println("true".asBoolean)
  }
}