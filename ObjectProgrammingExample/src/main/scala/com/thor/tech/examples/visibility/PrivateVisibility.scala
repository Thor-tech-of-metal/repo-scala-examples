package com.thor.tech.examples.visibility

class PrivateVisibility {

  private[this] def isFoo = true

  def doFoo(other: PrivateVisibility): Unit = {

    //************************* (other.isFoo) cannot see private[this]******************
    //if (other.isFoo)
  }
}

class PackageProtected(){
  private [visibility] def doX {}

}
class Bar {
  val f = new PackageProtected
  f.doX
}