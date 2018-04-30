package week6.example.other.collections.map

/**
  * Created by thor on 21/07/16.
  */
class Poly(termsParameter: Map[Int,Double]){

  val polyTerms= termsParameter withDefaultValue 0.0
  // bindings:(Int,Double)* n parameters of form (Int,Double)
  def this (bindings:(Int,Double)*)= this (bindings.toMap)

  //functions

  /**
    * This f() will perform poly sums. It sums the poly passed as parameter to the poly instance.
    * @param other this is the poly passed as parameter.
    * @return
    */
  def + (other:Poly)= new Poly (polyTerms ++  ( other.polyTerms map adjust ))
  // "other.polyTerms map adjust" it  will iterate each element of other.polyTerms and map it to
  // the function adjust

  def adjust(term: (Int,Double)):(Int,Double)={
    val (exp,coeff) = term
    //key-> value
    exp-> ( coeff+ polyTerms(exp) )
  }

  /**
    * This f() will perform poly sums. It sums the poly passed as parameter to the poly instance.
    * @param other this is the poly passed as parameter.
    * @return
    */
  def addInOneLine(other:Poly)= new Poly ( polyTerms ++ (

    other.polyTerms map(
                        // pattern (parameter:[parameterType]=>{function body})
                        (term:(Int,Double) ) => {
                          val (exp,coeff) = term
                          exp-> ( coeff+ polyTerms(exp) )
                         })
    ))

    override def toString()=
      ( for ( (exp,coeff) <- this.polyTerms.toList.sorted.reverse ) yield coeff +"x power "+exp) mkString " + "

}
object testPoly{

  def main(args: Array[String]) {

    val p1= new Poly (1->2.0, 3->4.0,5->6.2)
    val p2= new Poly(0->3.0,3->7.0)
    val p3= new Poly(0->3.0,3->7.0)

    p1 + p2

    p3.addInOneLine(p2)
    println("p1-->:"+p1)
    println("p3-->:"+p3)
    println(p1.polyTerms(7) )

  }

}
