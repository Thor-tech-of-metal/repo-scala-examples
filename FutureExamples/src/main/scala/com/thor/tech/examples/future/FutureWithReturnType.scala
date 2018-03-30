package com.thor.tech.examples.future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by tobias on 11/01/2017.
  */
object FutureWithReturnType  extends App {
  implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  // this does not block
  longRunningComputation(11).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace
  }

  // important: keep the jvm from shutting down
  sleep(1000)

  def sleep(time: Long) { Thread.sleep(time) }
}
