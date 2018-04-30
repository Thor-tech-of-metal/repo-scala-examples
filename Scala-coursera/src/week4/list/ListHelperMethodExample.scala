package week4.list


object ListHelperMethodExample {


}
/**
  * Created by thor on 11/07/16.
  */
class ListHelperMethodExample {

  /**
    * This method will return the last emelemt of a list.
    * @param list this is the list
    * @tparam T this is the parameter list type.
    * @return this is teh last element of a list of type T.
    */
  def last[T] (list: List [T] ) : T={

    list match {
      case List() => throw  new Error("The list cannot be empty")
      case List(headMatch1)=> headMatch1
      case headMatch2::tailMatch2 => last(tailMatch2)
    }
  }

  /**
    * This method will return a new list without the last element.
    * @param list this is the list
    * @tparam T this is the parameter list type.
    * @return a new list without the last element.
    */
  def init[T] (list: List[T]) : List[T] ={
    list match {

      case List() => throw  new Error("The list cannot be empty")
      case List(headMatch1)=> List()
      case headMatch2::tailMatch2 => headMatch2::init(tailMatch2)
    }
  }

  /**
    * This method concat two list and create a new one.
    * @param list1 this is the first list
    * @param list2 this is the second list
    * @tparam T this is the list type
    * @return a new list which is a concatenation of list1 and list2
    */
  def concat[T] (list1: List[T],list2: List[T] ): List[T]={

    list1 match {
      case List() => list2
      case head::tail => head::concat(tail,list2)
    }
  }

  /**
    * Return a new list in reverse insertion order.
    * @param list this is the list passed as parameter.
    * @tparam T T this is the list type
    * @return a new list in reverse insertion order.
    */
  def reverse[T] (list: List[T]) : List[T]={

    list match {
      case List() => List()
      case headMatch2::tailMatch2 => reverse(tailMatch2) ++ List(headMatch2)
    }
  }


  /**
    * Create a new list without the elemet passed a parameter.
    * @param index this is the index of the element that needs to be removed.
    * @param list this is the list.
    * @tparam T this is the list type
    * @return this is the new list without the element.
    */
  def removeAt[T] (index:Int, list: List[T]) = (list take index) ::: (list drop index +1)


  /**
    * This method creates a new sorted the the list
    * @param list this is the list to be sorted.
    * @return this the new sorted list.
    */
  def insertionSort(list: List[Int]): List[Int] = {

    list match {
      case List() => List()
      case head::tail => insert(head,insertionSort(tail))
    }
  }

  def insert(head:Int, list: List[Int]) : List[Int] ={

    list match {
      case List() => List(head)

      case headMatch::tail => {
        if (head <= headMatch) head :: list
        else headMatch:: insert(head,tail)
      }
    }
  }

}
