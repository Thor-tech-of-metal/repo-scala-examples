package com.thor.tech.examples.variance.advance.model


trait SuperCulo{

  def name:String
  def show:String

  override def toString = s"SuperCulo($name, $show)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Toto]

  override def equals(other: Any): Boolean = other match {
    case that: SuperCulo =>
      (that canEqual this) &&
        name == that.name
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

}

class NormalSuperCulo (override val name:String)  extends SuperCulo{

  override def show: String = s"This is a normal culo in ${name}"

  override def equals(other: Any): Boolean = super.equals(other)

  override def hashCode(): Int = super.hashCode()
}


class ExplosiveSuperCulo (override val name:String) extends NormalSuperCulo(name = "") {

  override def show: String = s"This is a explosive super culo in ${name}"

  override def equals(other: Any): Boolean = super.equals(other)

  override def hashCode(): Int = super.hashCode()
}


class Culazo (override val name:String) extends ExplosiveSuperCulo (name = ""){

  override def show: String = s"This is a culazo  culo in ${name}"

  override def equals(other: Any): Boolean = super.equals(other)

  override def hashCode(): Int = super.hashCode()
}

class Toto(override val name:String) extends Culazo (name = ""){

  override def show: String = s"This is a toto culo in ${name}"

  override def equals(other: Any): Boolean = super.equals(other)

}
