package com.thor.tech.examples.variance.advance

import com.thor.tech.examples.variance.advance.model.{Culazo, ExplosiveSuperCulo, Toto}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class CulosMagazineTest extends FlatSpec with Matchers  {

  it should s"Evaluate add culos  which belongs to this domain < Culo extends from SuperCulo and it is subclass of ExplosiveSuperCulo>." in {

    val inputsOkotes = List(new ExplosiveSuperCulo("culo explosivo"),new Culazo("this a culazo"), new Toto("this is a terrible toto"))

    //It only accepts ExplosiveSuperCulo, Culazo and Toto
    val culosMagazine: CulosMagazine[ExplosiveSuperCulo] =  CulosMagazine(inputsOkotes, Some(inputsOkotes.tail.head))

    val expectedResult = List(new Culazo("this a culazo"),new Toto("this is a terrible toto"))
    val expectedCulosMagazine = CulosMagazine(expectedResult, Some(expectedResult.head))

    val result = culosMagazine giveNextBullet()

    result match {
      case Some(magazine) => {

        magazine.lindosLocus.toString() should be (expectedResult.toString())
        magazine.currentLocu.toString should be (Some( new ExplosiveSuperCulo("culo explosivo")).toString)
      }

      case _ => fail()
    }
  }


  //hacer otro ejemplo parecido pero que tome un domino mas chico  desde Culazo  !! CulosMagazine[Culazo]
}
