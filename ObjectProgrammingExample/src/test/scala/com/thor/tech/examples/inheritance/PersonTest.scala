package com.thor.tech.examples.inheritance

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class PersonTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  val personName = "El carlo"
  val person= Person(personName)

  it should s"Evalute Person drinking" in {

    person.drink("water") should be("I am drinking water")
  }

  it should s"Evalute ${personName} walking" in {

    person.walk should be(s"${personName} is walking")
  }

  it should s"Evalute ${personName} eating something good" in {

    person.eat("Food") should be(s"${personName}  will eat the Food. yummy yummy!!!! Food")
  }

  it should s"Evalute ${personName} eating something crap" in {

    person.eat("Junk food") should be(s"${personName}  will no eat the Junk food.crap!!!! Junk food")
  }

}
