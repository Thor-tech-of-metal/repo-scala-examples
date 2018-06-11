package com.thor.tech.examples.inheritance

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MonkeyTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  val monkeyName = "Dirty monkey"
  val myMonkey= new Monkey("Dirty monkey")

  it should s"Evalute ${monkeyName} drinking" in {

    myMonkey.drink("water") should be("I am drinking water")
  }

  it should s"Evalute ${monkeyName} walking" in {

    myMonkey.walk should be("Dirty monkey is walking")
  }

  it should s"Evalute ${monkeyName} eating something good" in {

    myMonkey.eat("Mature Banana") should be("Monkey  will eat the Mature Banana. WA WA WA !!! Mature Banana")
  }

  it should s"Evalute ${monkeyName} eating something crap" in {

    myMonkey.eat("Junk food") should be("Monkey  will not eat the Junk food. WA WA WA !!! Junk food")
  }

}
