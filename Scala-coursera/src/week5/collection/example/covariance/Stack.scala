package week5.collection.example.covariance

/**
  * Created by thor on 15/08/16.
  */

// For our example this means Stack[A] is a subtype of Stack[B] if A is a subtype of B.
class Stack[+A] {

  def push[B >: A](elem: B): Stack[B] = {

    //stack inner class instance of B
    val stack= new Stack[B] {

      override def top: B = elem

      override def pop: Stack[B] = Stack.this

      override def toString() = elem.toString() + " " +
        Stack.this.toString()
    }
    return stack
  }

  def top: A = sys.error("no element on stack")
  def pop: Stack[A] = sys.error("no element on stack")

  override def toString() = ""
}

object VariancesTest extends App {

  //each stack can contain an inner calss instance of stack.
  //every push return a new instance of inner stack

  var s: Stack[Any] = new Stack().push("hello");
  s = s.push(new Object())
  s = s.push(7)

  println(s)
}