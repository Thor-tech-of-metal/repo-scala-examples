package com.thor.tech.examples.variance.covariants

/**
  * This is an example of scala convariance. This class is going to contains all subtypes of A
  * @param currentItem This is the current item drink of A type.
  * @param items This is the drinks container list.
  * @tparam A This is the type and +A all subtypes of A
  */
case class VendingMachine[+A](val currentItem: Option[A], items: List[A]) {

  def this(items: List[A]) = this(None, items)

  def dispenseNext(): VendingMachine[A] ={

    items match {
      case Nil => {
        if (currentItem.isDefined)  new VendingMachine(None, Nil)
        else this

      } case t :: ts => {
        new VendingMachine(Some(t), ts)
      }
    }
  }

  /**
    * This method is going add a List of Drinks in the immutable list.
    * @param newItems List of Drinks
    * @tparam B [B :> A] B is sub class of A.
    * @return a new instance of the VendingMachine.
    */
  def addAll[B >: A](newItems: List[B]): VendingMachine[B] = new VendingMachine(items ++ newItems)

}