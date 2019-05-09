

object testSort{

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

  val listInt1 = 1::3::4::Nil
  val listInt2= 4::3::2::Nil

  insertionSort(listInt1)
  insertionSort(listInt2)

  val xs = List("x")
  val ys = List("y")
  val zs = List("z")
  val l1 =xs ::: ys ::: zs
  val l2 = xs ::: (ys ::: zs)
  l1 == l2

}