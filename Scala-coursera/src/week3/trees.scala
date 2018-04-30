/**
  * Let’s consider implementing sets as binary trees.
  * There are two types of possible trees: a tree for the empty set,
  * and a tree consisting of an integer and two sub-trees.
  */
package object trees {

  var t1 = new NonEmpty(3, Empty, Empty)
  var t2 = t1 incl 4

}

/**
  * Created by thor on 04/07/16.
  */
abstract class IntSet {

  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union (other: IntSet) :IntSet

}

/**
  * Singleton.
  */
object Empty extends IntSet {

  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union (other: IntSet) = other

}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =

    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =

    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" +left +" | " + elem + " | "+ right +"}"

  def union (other: IntSet) : IntSet =

    ( ( left union right) union other) incl elem



}

