package com.thor.tech.examples.variance.advance

import com.thor.tech.examples.variance.advance.model.SuperCulo

/**
  * This is a class is a culos magazine which only displays the best culos.
  * @param lindosLocus This is the list of the best culos to be displayed in the magazine.
  * @param currentLocu this is the current culo which is displayed.
  * @tparam A any type subtype of A that also extends of Bullet
  */
final  case class CulosMagazine[+A <: SuperCulo](  val lindosLocus: List[A], val currentLocu: Option[A] ) {

  def hasBullets: Boolean = !lindosLocus.isEmpty

  def giveNextBullet(): Option[CulosMagazine[A]] =

    lindosLocus match {
      case Nil =>  None
      case head :: tail => {
        Some( new CulosMagazine(tail,Some(head)))
      }
    }

}