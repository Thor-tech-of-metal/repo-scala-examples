package com.thor.tech.examples.future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

/**
  * Created by tobias on 10/01/2017.
  */
object CreateFutureCallBack  extends App {


  def sleep(time: Long) { Thread.sleep(time) }

  println("starting calculation ...")

  val future = Future {
    sleep(Random.nextInt(500))
    42
  }
  println("before onComplete")

  future.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
  }
  // do the rest of your work
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  sleep(2000)
}
