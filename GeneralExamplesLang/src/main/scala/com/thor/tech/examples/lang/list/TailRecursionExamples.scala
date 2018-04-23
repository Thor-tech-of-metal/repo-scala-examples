package com.thor.tech.examples.lang.list

import scala.annotation.tailrec

/**
  * Created by thor on 29/08/16.
  */
class TailRecursionExamples {



  // Tail recursive.
  def reverseTailRecursive[A](ls: List[A]): List[A] = {

    @tailrec
    def reverseList[T](result: List[T], currentList: List[T]): List[T] ={

      currentList match {
        case List() => result
        case headMatch2::tailMatch2 => reverseList( headMatch2::result,tailMatch2)
      }
    }
    reverseList(Nil, ls)
  }


  def compressTailRecursive[A](ls: List[A]): List[A] = {

    @tailrec
    def compressRecursiveInternal[A](result: List[A],currentList:List[A] ): List[A] = {
      currentList match {

        case Nil => result.reverse
        case head ::tail =>compressRecursiveInternal( head ::result ,tail.dropWhile( _ == head))
      }
    }
    compressRecursiveInternal(Nil,ls)
  }


  def sumParameter[T](list: List[T], parameter: T )(operation:(T,T)=>T): List[T] = {

    @tailrec
    def sumParameterTailRecursion(result: List[T],myListToIterate:List[T] , p: T)(operation:(T,T)=>T): List[T] = {
      if (myListToIterate == Nil) result.reverse
      else sumParameterTailRecursion( operation(myListToIterate.head,p )::result , myListToIterate.tail,parameter )(operation)
    }

    sumParameterTailRecursion(Nil,list,parameter)(operation)
  }


}
