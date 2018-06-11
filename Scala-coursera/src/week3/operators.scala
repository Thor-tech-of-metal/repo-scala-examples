package week3

object operators {

  val rational1 = new RationalsWithOperators(1, 3)
  val rationals2 = new RationalsWithOperators(5, 7)
  val rationals3 = new RationalsWithOperators(3, 2)

  rational1.number
  rational1.demom

  rationals2 + rationals2
  rational1.-( rationals2).-(rationals3)

  //infix
  rational1 max rationals2
  rational1 < rationals2

  val strange = new RationalsWithOperators(1,0)
  strange.+(strange)

}

/**
  * Created by thor on 01/07/16.
  */
class RationalsWithOperators (x: Int, y: Int){
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
  //*** Attributes **//
  def number = x /g
  def demom = y/ g
  def unary_- : RationalsWithOperators =  new RationalsWithOperators(-number,demom)

  def + (that : RationalsWithOperators): RationalsWithOperators ={

    new RationalsWithOperators(this.number * that.demom + that.number * demom, demom * that.demom )

  }

  // Note that neg() is a function. But due to the fact that it ha no parameters it can be referred as neg
  def - (that: RationalsWithOperators)= this +  -that

  def < (that: RationalsWithOperators) = this.number * that.demom < that.number *  this.demom

  def max (that: RationalsWithOperators) =  if (this.<(that)) that else this

  override def toString(): String  = {

    this.number +"/" + this.demom
  }

}
