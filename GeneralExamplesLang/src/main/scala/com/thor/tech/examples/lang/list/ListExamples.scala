package com.thor.tech.examples.lang.list

import scala.collection.immutable.::

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
      case List() => throw  new Error("The list cannot be empty")
      case head :: Nil => head
      case head:: tail => getLastElement(tail)
    }
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
    case List() => throw new Error("The list cannot be empty")
  }

  // But pattern matching also makes it easy.
  def getPenultimateElement[A](ls: List[A]): A ={

    ls match {
      case List() => throw new Error("The list cannot be empty")
      case head :: tail :: Nil => head
      case head :: tail => getPenultimateElement(tail)
    }
  }

  // An obvious modification of the builtin solution works.
  def getPenultimateElementBuiltin[A](n: Int, ls: List[A]): A = {

    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
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


  def flatten(ls: List[Any]): List[Any] = {

    ls flatMap ( (list ) =>

      list match {
        //List[_] means list of everything
        case listOfList: List[_] => flatten(listOfList)
        case element => List(element)
      }
    )
  }

  def flattenCoolVersion(ls: List[Any]): List[Any] = {
    //In here is the (list ) => patter matching is ommited
    ls flatMap {
      case ms: List[_] => flatten(ms)
      case element => List(element)
    }
  }

  //Example:
  //scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) (
      (currentHead, tail) =>
        if (tail.isEmpty || tail.head != currentHead) currentHead :: tail
        else tail
    )

  //scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  def compressRecursive[A](ls: List[A]): List[A] ={
    ls match {
      case Nil => Nil
      case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
    }
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {

    def compressR(result: List[A], curList: List[A]): List[A] = {
      curList match {
        //_ == h  is the same as (head)=> head == h)
        case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
        case Nil => result.reverse
      }
    }
    compressR(Nil, ls)
  }

  /*scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)*/
  def duplicateElementNtimes [A](list:List[A], numberOfTimes:Int) ={

    list flatMap ( { element:A => List.fill(numberOfTimes)(element) } )
  }

  // recursive.
  def dropNelementRecursive[A](ls: List[A], indexToRemove:Int): List[A] = {

    def dropNelement(list: List[A], currentIndex:Int,indexToRemove:Int ): List[A] = {

      list match {
        case head :: tail => if(currentIndex==indexToRemove) tail.head ::dropNelement(tail.tail, currentIndex+1, indexToRemove)
                             else head ::dropNelement(tail, currentIndex+1, indexToRemove)
        case Nil => List()
        case List() => List()
      }
    }
    dropNelement(ls,0,indexToRemove)
  }


  // Functional.
  def dropIndexAndHisMultiplesElement[A](number: Int, list: List[A]): List[Any] ={
    // 1) zipWithIndex return a tuple list with each element and its index.
    // abcde.zipWithIndex List((a,0), (b,1), (c,2), (d,3),(e,4))
    // map ( _._1 ) is the same as  map ( tupleElement=> tupleElement._1 )
    list.zipWithIndex filter (tuple => (tuple._2 + 1) % number != 0  ) map ( _._1 )
  }


  // Not that much harder without.
  def rotate[A](position: Int, ls: List[A]): List[A] = {

    def rotateA[A](position: Int, ls: List[A], result: List[A]): List[A] = {
      /*println("ls"+ ls)
      println("result"+ result)*/

      (position, ls,result) match {

        case (position,head :: tail,Nil) => rotateA(position, ls, List(head))
        case (0, head :: tail,rHead::rTail ) => tail:::result
        case (position, head :: tail,rHead::rTail ) => rotateA(position - 1, tail, result:::List(tail.head))
        case (_, Nil,_) => throw new NoSuchElementException
      }

    }
    rotateA[A](position,ls,Nil)
  }

}

object ListExamplesTest {

  def main(args: Array[String]) {

    val list1 = 2 :: 3 :: 1 :: Nil
    val listExamples = new ListExamples

    println("getLastElementBuiltin :" + listExamples.getLastElementBuiltin(list1))
    println("getPenultimateElement :" + listExamples.getPenultimateElement(list1))
    println("getElement :" + listExamples.getElement(2, list1))
    println("reverseListFunctional :" + listExamples.reverseListFunctional(list1))
  }


}
