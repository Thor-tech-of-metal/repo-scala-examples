package com.thor.tech.examples.lang.higher.order.functions

import scala.annotation.tailrec

/**
  * Created by thor on 06/09/16.
  */

/**
  * Sum the any function for a range of numbers.
  */
class SumOperations {

  /**
    * Given that the rage between a and b can be a lot that could lead to stack overflow.
    * Therefore we can rewrite it as tail recursive functions.
    * A tail recursive version of the sun() function that sum fucntion for a range a to b.
    */

  def sum (operationF: Int=>Int, start: Int, end: Int):Int ={
    @tailrec
    def loop (a: Int, accumulator : Int ): Int =
      if ( a> end) accumulator
      else loop ( a +1, operationF(a) + accumulator)

    loop(start,0)
  }
}
object SumOperations extends App{

  val sumOperations= new SumOperations
   println( sumOperations.sum( x => x*x, 3,5) )
}
