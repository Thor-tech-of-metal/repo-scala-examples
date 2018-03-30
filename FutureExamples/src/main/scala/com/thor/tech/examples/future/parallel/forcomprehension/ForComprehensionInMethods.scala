package com.thor.tech.examples.future.parallel.forcomprehension

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, future}
import scala.util.Random
import scala.concurrent.duration._


/**
  * Created by tobias on 11/01/2017.
  */
object ForcomprehensionMethod extends App {

  println("starting futures")

  methodExample(false)

  println("before sleep at the end")
  sleep(2000)  // important: keep the jvm alive

  def sleep(time: Long) { Thread.sleep(time) }

  def methodExample(parameter:Boolean):Int={

    if(parameter){
      22
    }else{

      val result1 = Cloud2.runAlgorithm(10)

      val result = for { getResult1 <- result1 } yield (getResult1)

      val await = Await.result(result, 5.second).asInstanceOf[Int]
      await
    }
  }

}

object Cloud2 {

  def runAlgorithm(i: Int): Future[Int] = future {
    sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }

  def sleep(time: Long) { Thread.sleep(time) }
}