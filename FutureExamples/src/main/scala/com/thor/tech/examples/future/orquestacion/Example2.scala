package com.thor.tech.examples.future.orquestacion

import com.thor.tech.examples.future.orquestacion.Example1.sleep

import scala.concurrent.{Future, future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global



//Sorry for the sleep(1000) to make the main Future to wait !

// This can be better done with cats, I am not an expert with cats libs
object Example2 extends App {

  def sleep(time: Long) {
    Thread.sleep(time)
  }

  def funcion[A](a: A): Future[A] = future {
    a
  }

  def g[A](a: A, f: A => Future[A]): Future[Option[A]] = {
    val result = f(a)
    result map (element => Some(element)) recover { case t: Throwable => None }
  }



  g[Int](1, funcion).onComplete {

    case Success(value) => print(value.getOrElse("Error"))
    case Failure(e) => None
  }

  sleep(1000)

}

//Question 5
// This is a container MyAlg​ that has a F container with a genetic Type parameter.
// The good thing about it is that  F can have different class parameters which then are going to be implemented
// on contrate class parameter types in abstract methods such us  def​ insertItSomewhere​ (someInt: Int​): ​ F ​[​ Unit​] and
// def​ doSomething​ (someInt: Int​): ​ F ​[​ Unit​]


//trait​ MyAlg​[​F​[_]]{
//
//  def​ insertItSomewhere​ (someInt: Int​): ​ F ​[​ Unit​]
//  def​ doSomething​ (someInt: ​ Int​): F[​ Int​]
//}



