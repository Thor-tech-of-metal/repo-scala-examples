package com.thor.tech.examples

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class TestOptionExamples extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"mostIdiomaticExample zero" in {
    OptionExamples.mostIdiomaticExample(0) should be ("nothing it was zero! WA")
  }

  it should s"mostIdiomaticExample 1" in {
    OptionExamples.mostIdiomaticExample(1) should be ("2")
  }

  // BAD examples.

  it should s"mostIdiomaticExampleWhichIgnoreNone zero" in {
    OptionExamples.mostIdiomaticExampleWhichIgnoreNone(0) should be("nothing it was zero! WA")
  }

  it should s"mostIdiomaticExampleWhichIgnoreNone 1" in {
    OptionExamples.mostIdiomaticExampleWhichIgnoreNone(1) should be ("2")
  }

}
