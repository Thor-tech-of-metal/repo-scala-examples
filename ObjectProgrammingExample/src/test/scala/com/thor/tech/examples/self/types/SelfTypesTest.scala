package com.thor.tech.examples.self.types

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class SelfTypesTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"Evalute VerifiedTweeter in String" in {

    val realBeyonce = new VerifiedTweeter("Beyoncé")
    val result = realBeyonce.tweet("Just spilled my glass of lemonade")
    result should be ("real Beyoncé: Just spilled my glass of lemonade")
  }
}
