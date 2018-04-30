package week5.list.example

/**
  * Created by thor on 14/07/16.
  * Write a program that
  *
  */
class SplitWordsUtilsExample {

  /**
    * create a new list as of splitting a list of words in to sub list of words. For example:
    * List("a","a","a","b","b","c")--> List( List("a","a","a"), List("b","b"), List("c"))
    * @param list this is the lsit to be split
    * @tparam T this is the list type
    * @return new list as of splitting a list of words in to sub list of words.
    */
  def pack[T] (list:List[T]):List[List[T]] = {

    list match {
      case Nil=> Nil
      case (head::tail)=>{
        //span will create 2 lists one the matches and another without the matches.
        //it will return  2 list. matchSpan list with all span matches to parameter=> parameter==head
        // notMatchSpan list with all no span matches to parameter=> parameter==head
        val (matchSpan,notMatchSpan) = list.span( listElement=> listElement==head)
        matchSpan::pack(notMatchSpan)
      }
    }
  }


  /**
    * This function will count how many times a word was founf in the a list. It will return a new List
    * with this format List( List("a",3), List("b",2), List("c",1))
    * @param list this is the list parameter
    * @tparam T this is the list parameter type.
    * @return a new list with the result of counting the words in the list passed as parameter.
    */
  def countHowManyMatches[T] (list:List[T]):List[(T,Int)]={
    //listParameter.head,listParameter.length) this is function passed as parameter
    // listParameter.head,listParameter.length) -->
    //  (listParameter:List[T])  => (listParameter.head,listParameter.length)
    //  (listParameter:List[T])  => ( listParameter.head,listParameter.length)
    //
    pack(list).map( listParameter  => (listParameter.head,listParameter.length) )
  }

}

object SplitWordsExample1Test{

  def main(args: Array[String]) {

    val splitWordsExample1 = new SplitWordsUtilsExample
    val listTest=List("a","a","a","b","b","c")
    val pack=splitWordsExample1.pack(listTest)
    val countHowManyMatches=splitWordsExample1.countHowManyMatches(listTest)
    println(pack)
    println(countHowManyMatches)
  }
}