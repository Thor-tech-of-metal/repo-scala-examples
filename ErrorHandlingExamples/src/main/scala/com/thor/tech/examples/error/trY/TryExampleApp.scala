package com.thor.tech.examples.error.trY

import scala.util.Try

/**
  * Created by tobias on 16/03/2017.
  */

object TryExampleApp extends App{

  def tryMe( ) : Unit = {

    val sum = for {
      int1 <- Try(Integer.parseInt("one"))
      int2 <- Try(Integer.parseInt("two"))
    } yield {
      int1 + int2
    }
    sum.recover{
      case e => 0
    }
    println(sum)
  }

  tryMe()
}

