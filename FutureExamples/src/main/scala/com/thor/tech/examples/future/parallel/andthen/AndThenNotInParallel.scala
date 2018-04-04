package com.thor.tech.examples.future.parallel.andthen


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by tobias on 25/01/2017.
  */
object AndThenNotInParallel extends App{

  // the for {} construct lets us execute multiple futures in parallel
  // to serially execute futures in specific orders, we use `andThen`
  // andThen ensures execution orders in what would otherwise be random

  val dontBreakMyBalls = Future {
    Thread.sleep(500)
    Console.println("Dont !")
  } andThen {
    case _ => {
      Thread.sleep(500)
      Console.println("Break my balls!")
    }
  } andThen {
    case _ => {
      Thread.sleep(500)
      Console.println("Thank you ma'am!")
    }
  }

  Console.println("Lets do things in not in parallel and corrdinate them. 1 and then 2 and then 3")

  Thread.sleep(2000)

}
