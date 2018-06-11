package com.thor.tech.examples.implicits.utils

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

import com.thor.tech.examples.implicits.utils.StringImprovements._

class ImplicitsTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"Evalute increment() in String" in {

    "inspor".increment should be("jotqps")
  }

  it should s"Evalute plusOne() in String" in {

    "1".plusOne should be(2)
  }

  it should s"Evalute asBoolean() in String" in {

    "true".asBoolean should be(true)
  }

}
