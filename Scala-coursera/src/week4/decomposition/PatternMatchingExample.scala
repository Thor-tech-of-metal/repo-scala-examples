package week4.decomposition

object evaluateInterpreter1 {

  val expr = new Sum2( Num2(1),Num2(2))
  expr.toString
}


/**
  * This is an example that can show how decomposition ca be resolved using pattern matching.
  */
class ExprPatternMatching{

  def eval : Int ={

    this match {
      case Num2 (n) => n
      case Sum2 (e1,e2) => e1.eval + e2.eval
    }

  }
  override  def toString : String = "value: " + eval
}

case class Num2 (number: Int) extends ExprPatternMatching{

}
case class Sum2(expr1: ExprPatternMatching, expr2: ExprPatternMatching) extends ExprPatternMatching{
}


