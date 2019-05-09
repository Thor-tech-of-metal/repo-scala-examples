/**
  * Write a function that calculates
  * 1) sum ints
  * 2) sume cubes
  * 3) sume of factorials
  * in one function.
  */
object curryingExample2{

  def fact(value: Int): Int =
    if (value == 0) 1
    else fact(value - 1)

  def sumInts (a: Int, b: Int): Int = sum(x => x) (a,b)
  def sumCubes (a: Int, b: Int): Int = sum(x => x * x * x)(a,b)
  def sumFactorials (a: Int, b: Int): Int = sum(fact)(a,b)

  def cubes (x:Int) :Int = x*x*x

  def sum(f: Int => Int) (a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  }



  sumInts(1, 3)

  sumCubes (1, 2)
  //it is the same than sumCubes (1, 2)
  sum (x => x * x * x) (1, 2)
  //it is the same than sumCubes (1, 2)
  sum (cubes) (1, 2)
  sumFactorials (1, 10)
}