package com.thor.tech.examples

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class Question3Test extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"The present values lenght" in {

    val expectedResult = 1001
    Question3.values.size should be (expectedResult)
  }

  it should s"For Nil " in {

    val expectedResult = Nil
    Question3.getThePlusOneValue(Nil) should be (expectedResult)
  }

  it should s"For 0 " in {

    val expectedResult = Seq(1)
    Question3.getThePlusOneValue(Seq(0)) should be (expectedResult)
  }


  it should s"For 999 " in {

    val expectedResult = Seq(1000)
    Question3.getThePlusOneValue(Seq(999)) should be (expectedResult)
  }


  it should s"For 123 " in {

    val expectedResult = Seq(124)
    Question3.getThePlusOneValue(Seq(123)) should be (expectedResult)
  }

}
