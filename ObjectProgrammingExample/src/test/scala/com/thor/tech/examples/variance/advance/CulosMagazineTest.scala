package com.thor.tech.examples.variance.advance

import com.thor.tech.examples.variance.advance.model.{Culazo, ExplosiveSuperCulo, Toto}
import org.scalatest.{FlatSpec, Matchers}

class CulosMagazineTest extends FlatSpec with Matchers  {

  it should s"Evaluate add culos  which belongs to this domain < Culo extends from SuperCulo and it is subclass of ExplosiveSuperCulo>." in {

    val inputsOkotes = List(new ExplosiveSuperCulo("culo explosivo"),new Culazo("this a culazo"), new Toto("this is a terrible toto"))

    //I have the folowing classes
    //SuperCulo-->NormalSuperCulo-->ExplosiveSuperCulo-->Culazo-->Toto
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


  it should s"Evaluate add culos  which belongs to this domain < Culo extends from SuperCulo and it is subclass of Culazo>." in {

    val inputsOkotes = List(new Culazo("this a culazo"), new Toto("this is a terrible toto"))

    //I have the folowing classes
    //SuperCulo-->NormalSuperCulo-->ExplosiveSuperCulo-->Culazo-->Toto
    //It only accepts Toto and Culazo. All subclasses of Culazo and extends from SuperCulo.
    val culosMagazine: CulosMagazine[Culazo] =  CulosMagazine(inputsOkotes, Some(inputsOkotes.tail.head))

    val expectedResult = List(new Toto("this is a terrible toto"))
    val expectedCulosMagazine = CulosMagazine(expectedResult, Some(expectedResult.head))

    val result = culosMagazine giveNextBullet()

    result match {
      case Some(magazine) => {

        magazine.lindosLocus.toString() should be (expectedResult.toString())
        magazine.currentLocu.toString should be (Some( new Culazo("this a culazo")).toString)
      }

      case _ => fail()
    }
  }
}
