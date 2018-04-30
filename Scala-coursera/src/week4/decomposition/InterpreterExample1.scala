package week4.decomposition

object evaluateInterpreter {

  val expr = new Sum(new Num(1),new Num(2))
  expr.toString
}

/**
  * This is an example that can show how decomposition ca be resolved using Object orientated solution.
  * The solution is a concrete implementation of eval in each class implementation.
  */
trait Expr{

  def eval : Int
  override  def toString : String = "value: " + eval
}

class Num (number: Int) extends Expr{

  override  def eval : Int= number
}

class Sum(expr1: Expr, expr2: Expr) extends Expr{

  override  def eval: Int= expr1.eval + expr2.eval
}
