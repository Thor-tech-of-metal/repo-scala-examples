package com.thor.tech.examples.future.error.handling

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
/**
  * Created by tobias on 25/01/2017.
  */
object Recover extends  App{

  val tryDivideByZeroAgain = Future {
    Thread.sleep(1000)
    1 / 0
  } recover {
    case e: ArithmeticException => "Infinity"
  }

  tryDivideByZeroAgain onSuccess {
    case e => Console.println(e)
  }

  tryDivideByZeroAgain onFailure {
    case e => Console.println(e)
  }


  Console.println("Try dividing by zero, recover from exception..")

  Thread.sleep(2000)

  // output
  // Try dividing by zero, recover from exception..
  // Infinity

}
