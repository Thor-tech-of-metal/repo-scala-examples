package com.thor.tech.examples.lang.list

/**
  * Created by thor on 18/08/16.
  */
class EncodingListExamples {

  //*scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def pack[A](ls: List[A]): List[List[A]] = {

    if (ls.isEmpty) List(List())
    else {
      // it will return a tuple with (fields fulfill condition, fields no fuflill condition )
      // list with the repeated characters.
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  //scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List( List(4,'a), List(1,'b), List(2,'c), List(2,'a), List(1,'d), List(4,'e))
  def packALength[A](ls: List[A]): List[Any] = {

    if (ls.isEmpty) List(List())
    else {
      // it will retuen a list with the repeated characters. List(matches),List(notMatches)
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List( List(packed.length,packed.head))
      else List(packed.length,packed.head):: packALength(next)
    }
  }

  //scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encode[A](ls: List[A]): List[(Int, A)] ={

    pack(ls) map { eachList => (eachList.length, eachList.head) }
  }


  def decode[A](ls: List[(Int, A)]): List[Any] ={

    ls match {
      case Nil => Nil
      case tuple :: tail =>  List.fill(tuple._1)(tuple._2)::decode(tail)
    }
  }

  def decodeAsSimpleListList[A](ls: List[(Int, A)]): List[A] =

    ls flatMap ( tupleElement => List.fill(tupleElement._1)( tupleElement._2) )

/* Estoy por aca es un kilombo P11    http://aperiodic.net/phil/scala/s-99/#p20*/

}
