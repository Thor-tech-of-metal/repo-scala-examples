package week3
object ConstListExample {

  val myList= List(List(true, false), List(3))
  val myList2= List(1,2,3)

  /**
    * This method will iterate the list looking for the element located in the element position passed as parameter.
    *
    * @param position this is the elemet position in the list.
    * @param list This is the list of elements.
    * @tparam T this is the list container type. For example a list of Int
    * @return this is the element that will be return
    */
  def getElement [T] (position:Int, list: ListGeneric[T] ) :T ={

    if ( list.isEmpty) throw new IndexOutOfBoundsException()
    else if (position== 0 ) list.head
    else getElement(position-1,list.tail)
  }

  val myListCons = new Cons[Int](1, new Cons[Int](2,new Cons[Int](3,new Nil)))
  getElement[Int](2,myListCons)
  getElement(1,myListCons)

}

/**
  * This is an example of an immutable linked list.
  *
  */

/**
  * This is the trait class which is an abstraction of a list
  *
  * @tparam T this is the generic paramter that can be passed to the class.
  */
trait ListGeneric[T] {
  // This is the list head the actual value
  def head: T
  // this is the pointer to another list
  def tail: ListGeneric[T]

  def isEmpty: Boolean
}

/**
  * This is the representation of a empty Nil list value.
  *
  * @tparam T this is the generic paramter that can be passed to the class.
  */
class Nil[T] extends ListGeneric[T] {

  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")

}

/**
  * This is an implementation of the const list it self.
  *
  * @param head this is the value.
  * @param tail this is the pointer to another list
  * @tparam T this is the generic paramter that can be passed to the class.
  */
class Cons[T](val head: T, val tail: ListGeneric[T]) extends ListGeneric[T] {

  override def isEmpty = false
}
