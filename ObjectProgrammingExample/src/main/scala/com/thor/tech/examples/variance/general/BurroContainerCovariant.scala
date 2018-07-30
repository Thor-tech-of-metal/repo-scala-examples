package com.thor.tech.examples.variance.general

import com.thor.tech.examples.variance.general.model.Mammal


sealed  trait SuperBurroContainer{

  def name:String

  override def toString: String = s"This is the container name ${name}"
}

class BurroContainerInvariant [T] ( override val name:String) extends SuperBurroContainer

class BurroContainerCovariant [+T] ( override val name:String) extends SuperBurroContainer

class BurroContainerContravariant [-T] ( override val name:String) extends SuperBurroContainer


case class  Container (val container:List[String]) {

  def methodInvariant(container:BurroContainerInvariant[Mammal])  =  Container ( this.container:::List( container.toString) )

  def methodCovaraint(container:BurroContainerCovariant[Mammal]) = Container ( this.container:::List( container.toString) )

  def methodContravaraint(container:BurroContainerContravariant[Mammal])  = Container ( this.container:::List( container.toString) )


}