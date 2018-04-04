package com.thor.tech.examples.error.either

import java.util.StringTokenizer

/**
  * Created by tobias on 16/03/2017.
  */

case class FailResult(reason:String)

object EitherExample extends App{

  def parse(input:String) : Either[FailResult, String] = {

    val tokenizer = new StringTokenizer(input)
    if (tokenizer.countTokens() == 1) {
      Right(tokenizer.nextToken())
    } else {
      Left(FailResult("Could not parse string: " + input))
    }
  }

  val rightFoo = for (outputFoo <- parse("A").right) yield outputFoo

  println(rightFoo)


  val fail = for (outputFoo <- parse("").right) yield outputFoo

  println(fail)

}



