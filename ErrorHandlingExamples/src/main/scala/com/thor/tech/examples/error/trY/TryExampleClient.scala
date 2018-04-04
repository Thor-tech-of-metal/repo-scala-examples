package com.thor.tech.examples.error.trY

import java.io.FileNotFoundException
import java.net.MalformedURLException

import scala.util.{Failure, Success}

object TryExampleClient {


  def mapASuccessTry(input: String): String = {

    TryExample.parseURL(input) map {
      element =>
        element.getProtocol
        print(s"Map a successful result only.")
        println(s"the result is ${element}")
        return element.toString
    }
    "error"
  }

  def mapTryWithGetElse(input: String): String = {

    val result = TryExample.parseURL(input)

    print(s"the result ${result} will not be mapped. becuase is a failure.")
    // this whole code will not be executed. because the try result will be an Failure[exception]

    result map {
      element =>
        element.getProtocol
        println(s"the result is a failure ${element}")
        element.toString

    } getOrElse {
      println(s"the result is a failure.")
      "error"
    }
  }


  def flatMapTry(input: String): String = {

    TryExample.parseURL(input) flatMap {
      element =>
        element.getProtocol
        print(s"Map a successful result only.")
        println(s"the result is ${element}")
        return element.toString
    }
    "error"
  }

  def matchTry(inputUrl: String): Either[String, String] = {

    TryExample.parseURL(inputUrl) match {

      case Success(result) =>
        println(s"the result ${result} is successful. ")
        Right(result.toString)

      case Failure(result) =>
        println(s"the result ${result} is no successful. ")
        Left("error")
    }
  }

  def forComprehensionATry(input: String): Either[String, String] = {

    TryExample.getURLContent(input) map  {
      element =>
        println(element)
        Right("Ok")
    } getOrElse {
      Left("BAD")
    }
  }

  def recoverATry(input: String): Either[String, String] = {

    val content = TryExample.parseURL(input) recover {

      case exception: FileNotFoundException => return Left("BAD")
      case exception: MalformedURLException => return Left("BAD")
      case _ => return Left("BAD")
    }
    return Right("Ok")
  }
}

