/**
  * Created by thor on 30/06/16.
  */
package object rationals {

  val rational1 = new Rationals(1, 3)
  val rationals2 = new Rationals(5, 7)
  val rationals3 = new Rationals(3, 2)

  rational1.number
  rational1.demom

  rationals2.add(rationals2)
  rational1.sub(rationals2).sub(rationals3)

  rational1.max(rationals2)
  rational1.less(rationals2)

  val strange = new Rationals(1,0)
  strange.add(strange)

}

class Rationals (x: Int, y: Int){
  require(y !=0 ,"denominator must be nozero")

  /**
    * This function will return the greatest common denominator
    *
    * @param a this is the number
    * @param b this is the denom
    * @return return the greatest common denominator.
    */
  private def greatestCommonDenominator( a: Int, b: Int):Int ={

    //In scala the code is interpreted that is why the function should be declared before it is used.
    if ( b==0) a
    else greatestCommonDenominator(b, a % b)
  }

  private val g = greatestCommonDenominator(x,y)

  // all values a simplified from the beginning
  def number = x /g
  def demom = y/ g

  def add (that : Rationals): Rationals ={

    new Rationals(this.number * that.demom + that.number * demom, demom * that.demom )

  }

  def neg: Rationals =  new Rationals(-number,demom)

  // Note that neg() is a function. But due to the fact that it ha no paramters it can be refered as neg
  def sub (that: Rationals)= add(that.neg)

  def less (that: Rationals) = this.number * that.demom < that.number *  this.demom

  def max (that: Rationals) =  if (this.less(that)) that else this

  override def toString(): String  = {

    this.number +"/" + this.demom
  }

}
