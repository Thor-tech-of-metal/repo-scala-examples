package week4



object testSortClass{

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

  val listInt1 = 4::3::Nil
  insertionSort(listInt1)


}