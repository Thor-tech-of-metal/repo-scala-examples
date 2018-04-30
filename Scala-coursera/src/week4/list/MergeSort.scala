package week4.list

/**
  * This class will sort a list using the bubble sort.
  * 1) Split the list in 2 list from the middle point.
  * 2) Sort 2 sub lists
  * 3) Merge the two sorted list in to a new sorted list.
  */
class MergeSort() {

  def  mergeSort[T](listToBeSorted: List[T]) ( lt: (T,T) => Boolean ) : List [T] = {

    val halfPoint= listToBeSorted.length/2
    if (halfPoint==0) listToBeSorted
    else {

      def merge (list1: List[T],list2: List[T]): List[T]={

        (list1,list2) match {
          case (list1,Nil) => list1
          case (Nil,list2) => list2

          // headMatch1::tailMatch1 all list have a Int head and List tail
          // [head]::[tail]
          // headMatch1::tailMatch1 --> is a match ot list1
          // headMatch2::tailMatch2 --> is a match ot list2

          case (headMatch1::tailMatch1,headMatch2::tailMatch2)=> {
            if (lt (headMatch1,headMatch2) ) headMatch1 :: merge(tailMatch1, list2)
            else headMatch2 :: merge(list1, tailMatch2)
          }
        }
      }
      val (first,second) = listToBeSorted splitAt(halfPoint)
      merge(mergeSort(first)(lt),mergeSort(second)(lt))
    }
  }
}

object MergeSortTest {

  def main(args: Array[String]) = {

    val mergeSort=new MergeSort

    val numList = 1::9::5::6::Nil
    val result= mergeSort.mergeSort(numList)((x:Int,y:Int)=>x < y)

    val stringList = "S"::"A"::"C"::Nil
    val result1= mergeSort.mergeSort(stringList)( (x:String,y:String)=> x.compareTo(y) <0 )

    println(result)
    println(result1)
  }
}
