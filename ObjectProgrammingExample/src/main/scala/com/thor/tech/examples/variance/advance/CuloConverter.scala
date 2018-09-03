package com.thor.tech.examples.variance.advance

import com.thor.tech.examples.variance.advance.model._

/**
  * This is a converter which convert from one culo in to the another.
  *
  * @param factory this is the f() factory used to create templates constructors.
  * @tparam T this is the base template
  * @tparam R this is the new converted type.
  */
class CuloConverter[-T <: SuperCulo, +R](val factory: (String) => R) extends AnyRef {

  def convert(locu: T): R = {

    return factory(locu.name)
  }
}

case object CulosFactory {

  val normalSuperCulo = { (paramter: String) => new NormalSuperCulo(paramter) }

  val explosiveSuperCulo = { (paramter: String) => new ExplosiveSuperCulo(paramter) }

  val culazo = { (paramter: String) => new Culazo(paramter) }

  val Toto = { (paramter: String) => new Toto(paramter) }

}


