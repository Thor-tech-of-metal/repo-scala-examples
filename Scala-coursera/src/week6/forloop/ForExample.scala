package week6.forloop

/**
  * Created by thor on 19/07/16.
  */
class ForExample {

  /**
    * This function will return all element that are prime of number
    *
    * @param number this is the number
    * @return a list with all primes
    */
  def isPrime(number:Int):Boolean={

    (2 until number).forall(d => d%number!=0 )
  }

  /**
    * Sum of the product of list1[elemnt-N]* list2[elemnt-N]
    *
    * @param list1
    * @param list2
    * @return Sum of the product of list1[elemnt-N]* list2[elemnt-N]
    */
  def scalarPorduct(list1: List[Double],list2: List[Double]): Double={

    //zip return a collection of pairs like this one List((1,3),(2,3))
    //irerate this list and put in paild x and y
    // perform the x*y
    // crete a new list of x*y
    // and sum List(x*y ,x*y ,x*y )
    ( for ((x,y) <- list1 zip list2 )
      yield x*y
    ).sum

  }


  def printPrimeNumbers(n:Int)={

    //val result= Vector[(Int,Int)]
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    }
    yield (i,j)
  }

}

object ForExampleObject{

  def main(args: Array[String]) {

    val n=4
    val list1= 1D::2D::3D::Nil
    val list2= 1D::1D::3D::Nil
    val forExample= new ForExample()

    val scalarPorduct = forExample.scalarPorduct(list1,list2)
    val result=forExample.printPrimeNumbers(n)
    print(result)
  }
}
