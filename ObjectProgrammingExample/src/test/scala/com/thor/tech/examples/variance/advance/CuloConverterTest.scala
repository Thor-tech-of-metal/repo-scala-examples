package com.thor.tech.examples.variance.advance

import com.thor.tech.examples.variance.advance.model.{Culazo, ExplosiveSuperCulo, NormalSuperCulo, Toto}
import org.scalatest.{FlatSpec, Matchers}

class CuloConverterTest extends FlatSpec with Matchers {

  it should s"Evaluate CuloConverter from  NormalSuperCulo to ExplosiveSuperCulo." in {

    val expectedResult = new ExplosiveSuperCulo("Pan dulce")
    val culoConverter = new CuloConverter[NormalSuperCulo,ExplosiveSuperCulo](CulosFactory.explosiveSuperCulo)

    val explosiveSuperCulo = culoConverter.convert(new NormalSuperCulo("Pan dulce"))

    explosiveSuperCulo.toString should be (expectedResult.toString)
  }



  it should s"Evaluate CuloConverter from  Toto to Culazo." in {

    val expectedResult = new Culazo("Pan dulce")
    val culoConverter = new CuloConverter[Toto,Culazo](CulosFactory.culazo)

    val explosiveSuperCulo = culoConverter.convert(new Toto("Pan dulce"))

    explosiveSuperCulo.toString should be (expectedResult.toString)
  }

}
