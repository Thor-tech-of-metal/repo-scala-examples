package com.thor.tech.examples.future.orquestacion

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, future}


//Sorry for the sleep(1000) to make the main Future to wait !

// This can be better done with onComplete but it return units for that reason flatMap
object Example1 extends App {

  def f1(): Future[Unit] = future {
    println("f1")
  }

  def f2(): Future[Unit] = future {
    println("f2")
  }

  def f3(): Future[Unit] = future {
    println("f3")
  }

  def f4(): Future[Unit] = future {
    println("f4")
  }

  def case1(): Unit = {

    println("independentCalls")
    f1()
    f2()
    f3()
    f4()
  }

  def case2(): Unit = {

    println("f4 depends on f3 which depends on f2 which depends on f1")

    val futResult: Future[Unit] =
      f1().flatMap( r1 =>
        f2().flatMap( r2 =>
          f3().flatMap( r3 => f4() )
        )
      )
    sleep(1000)

    //or using a for comprehension :
  }


  def case3(): Unit = {

//    f4 depends --> f3
//    f4 depends --> f2
//    f3 depends --> f1
//    f2 depends --> f1

    println("f4 depends on f3 and f2, and f3 and f2 both depend on f1")

    val futResult: Future[Unit] =
      f1().flatMap { r1 =>
        f2()
        f3().flatMap( r2 => f4())

      }
    sleep(1000)
  }

  case1()
  case2()
  case3()

  def sleep(time: Long) { Thread.sleep(time) }
}

