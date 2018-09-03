package week5.list.example

/**
  * Created by thor on 16/08/16.
  */
class ListExamples {

  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def getLastElementBuiltin[A](ls: List[A]): A = ls.last


  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def getLastElement[A](ls: List[A]): A = {

    ls match {
      case head :: Nil => head
      case head:: tail => getLastElement(tail)
      case List() => throw  new Error("The list cannot be empty")
    }
  }


  // But pattern matching also makes it easy.
  def getPenultimateElement[A](ls: List[A]): A ={

    ls match {
      case head :: tail :: Nil => head
      case head :: tail => getPenultimateElement(tail)
      case List() => throw new Error("The list cannot be empty")
    }
  }

  // An obvious modification of the builtin solution works.
  def getPenultimateElementBuiltin[A](n: Int, ls: List[A]): A = {

    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }



  // Trivial with builtins.
  def getElementBuildIn[A](n: Int, ls: List[A]): A =
    if (n >= 0) ls(n)
    else throw new NoSuchElementException

  // Not that much harder without.
  def getElement[A](position: Int, ls: List[A]): A = (position, ls) match {

    case (0, head :: tail   ) => head
    case (position, head :: tail) => getElement(position - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }


  def reverseList[T] (list: List[T]) : List[T]={

    list match {
      case List() => List()
      case headMatch2::tailMatch2 => reverseList(tailMatch2) ++ List(headMatch2)
    }
  }


  // Tail recursive.
  def reverseTailRecursive[A](ls: List[A]): List[A] = {

    def reverseR(result: List[A], curList: List[A]): List[A] = {

      curList match {
        case Nil => result
        case head :: tail => reverseR(head :: result, tail)
      }
    }

    reverseR(Nil, ls)
  }

  // Pure functional
  def reverseListFunctional[A](ls: List[A]): List[A] ={

    //where List[A]()  is the zero and
    // (tail, head) => head :: tail is the function passed as parameter to the foldLeft
    ls.foldLeft( List[A]() ) ( (tail, head) => head :: tail )
  }

}

object ListExamplesTest{

  def main(args: Array[String]) {

    val list1 = 2::3::1::Nil
    val listExamples = new ListExamples

    println("getLastElementBuiltin :"+listExamples.getLastElementBuiltin(list1))
    println("getPenultimateElement :"+listExamples.getPenultimateElement(list1))
    println("getElement :"+listExamples.getElement(2,list1))
    println("reverseListFunctional :"+listExamples.reverseListFunctional(list1))
  }

}
