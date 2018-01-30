package com.thor.tech.examples.error

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class TestTryExamples extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  // match a Try[T]
  it should s"the match try should be  successful" in {
    val input = "http://goggle.com"
    TryExampleClient.matchTry(input) should be (Right(input))
  }

  it should s"the match try should be  no successful" in {
    val input = "xxx"
    TryExampleClient.matchTry(input) should be (Left("error"))
  }

  // map with else a Try[T]
  it should s"the map try with else value should be successful" in {
    val input = "http://goggle.com"
    TryExampleClient.mapTryWithGetElse(input) should be (input)
  }

  it should s"the map with else value try should no be successful" in {
    val input = "xxx"
    TryExampleClient.mapTryWithGetElse(input) should be ("error")
  }

  // map a Try[T] without else.
  it should s"the map try should be successful" in {
    val input = "http://goggle.com"
    TryExampleClient.mapASuccessTry(input) should be (input)
  }

  it should s"the map try should no be successful" in {
    val input = "xxx"
    TryExampleClient.mapASuccessTry(input) should be ("error")
  }

  // flat map a Try[T]
  it should s"flat map a try should be successful" in {
    val input = "http://goggle.com"
    TryExampleClient.flatMapTry(input) should be (input)
  }

  it should s"flat map a try should not be successful" in {
    val input = "xxx"
    TryExampleClient.flatMapTry(input) should be ("error")
  }

  //For comprehension a Try
  it should s"For comprehension a Try should be successful" in {
    val input = "http://goggle.com"
    TryExampleClient.forComprehensionATry(input) should be (Right("Ok"))
  }

  it should s"For comprehension a Try should not be successful" in {
    val input = "xxx"
    TryExampleClient.forComprehensionATry(input) should be (Left("BAD"))
  }

  //Try with recover
  it should s"Try with recover should be successful" in {
    val input = "http://goggle.com"
    TryExampleClient.recoverATry(input) should be (Right("Ok"))
  }

  it should s"Try with recover should not be successful" in {
    val input = "xxx"
    TryExampleClient.recoverATry(input) should be (Left("BAD"))
  }

}
