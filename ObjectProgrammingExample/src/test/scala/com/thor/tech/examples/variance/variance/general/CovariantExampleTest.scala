package com.thor.tech.examples.variance.variance.general
import com.thor.tech.examples.variance.general.model.{Animal, Dog, Mammal}
import com.thor.tech.examples.variance.general.{BurroContainerContravariant, BurroContainerCovariant, BurroContainerInvariant, Container}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class CovariantExampleTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {


  it should s"Test covariance test from Mammal. It will only work  for Mammal and its subclasses such us Dog" in {

    val expectedResult=List("This is the container name Mammal", "This is the container name Dog")
    val container = new Container(List())

    val result = container.methodCovaraint(new BurroContainerCovariant[Mammal]("Mammal"))
    val lastResult = result.methodCovaraint(new BurroContainerCovariant[Dog]("Dog"))

    lastResult.container should be(expectedResult)
  }


  it should s"Test contravariance test from Mammal. It will only work  for Mammal and its super classes such us Animal." in {

    val expectedResult=List("This is the container name Animal", "This is the container name Mammal")
    val container = new Container(List())

    val result = container.methodContravaraint(new BurroContainerContravariant[Animal]("Animal"))
    val lastResult = result.methodContravaraint(new BurroContainerContravariant[Mammal]("Mammal"))

    lastResult.container should be(expectedResult)
  }


  it should s"Test invariant test for Mammal. It will only work  for Mammal." in {

    val expectedResult=List("This is the container name Mammal")
    val container = new Container(List())

    val result = container.methodInvariant(new BurroContainerInvariant[Mammal]("Mammal"))
    result.container should be(expectedResult)
  }

}