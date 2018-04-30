/**
  * Write a function that calculates
  * 1) sum ints
  * 2) sume cubes
  * 3) sume of factorials
  * in one function.
  */
object curryingExample1{

  def fact(value: Int): Int =
    if (value == 0) 1
    else fact(value - 1)

  def sumInts = sum(x => x)
  def sumCubes = sum(x => x * x * x)
  def sumFactorials = sum(fact)

  def sum (f: Int=> Int) : (Int,Int)=> Int = {

    def sumF (a :Int, b: Int): Int ={
      if (a > b) 0
      else f(a) + sumF(a+1,b)
    }
    sumF

  }

  sumInts (1, 3)
  sumCubes (1, 2)
  //it is the same than sumCubes (1, 2)
  sum (x => x * x * x) (1, 2)
  sumFactorials (1, 10)



}