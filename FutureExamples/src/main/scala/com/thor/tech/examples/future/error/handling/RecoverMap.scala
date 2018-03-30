package com.thor.tech.examples.future.error.handling

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by tobias on 25/01/2017.
  */
object RecoverMap extends  App{

  val future:Future[Int] = longRunningComputation(20)

  val resultFinal= future map { result =>
    if (result > 10)  s"this is the ${result}"
    else  1/0
  } recover{
    case e: ArithmeticException => Console.println(e.toString)
  }


  val resultFinals= future map {

    case a:Int => {
        if (a > 10)  s"this is the ${a}"
        else  1/0
      }

  } recover{
    case e: ArithmeticException => Console.println(e.toString)
  }

  def longRunningComputation(i: Int): Future[Int] = Future {
    Thread.sleep(2000)
    i + 1
  }

  future onFailure {
    case e => Console.println(e)
  }
  Thread.sleep(5000)
  Console.println("wailt a lot for the future to complete bad bad!!")
  Console.println(resultFinal)
  Console.println("Try dividing by zero, recover from exception..")

}
