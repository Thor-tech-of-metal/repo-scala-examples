package com.thor.tech.examples.lang.implicits.classes.utils

/**
  * Created by tobias on 01/02/2017.
  * http://alvinalexander.com/scala/scala-2.10-implicit-class-example
  */
object StringImprovements {

  implicit class StringImprovementsImpl(val string: String) {

    def increment = string.map(character => (character + 1).toChar)

    def plusOne = string.toInt + 1

    def asBoolean = string match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }
}
