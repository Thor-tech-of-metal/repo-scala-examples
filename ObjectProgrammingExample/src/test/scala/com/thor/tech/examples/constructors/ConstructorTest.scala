package com.thor.tech.examples.constructors

import com.thor.tech.examples.implicits.utils.StringImprovements._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class ConstructorTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"Path constructor with parameters (1,1)" in {

    val expectedResult = List( "x: = 1 and y: = 1")
    new Path( (1,1) ).getAllCoordinates should be (expectedResult)
  }

  it should s"Path constructor with parameters (1,1), (2,2)" in {

    val expectedResult = List( "x: = 1 and y: = 1","x: = 2 and y: = 2")
    new Path( (1,1), (2,2) ).getAllCoordinates should be (expectedResult)
  }


}
