package week5.list.example

/**
  * Created by thor on 14/07/16.
  */
class ListFuctionExamples {


  /**
    * This function is going to perform a math operation to each list parameters.
    *
    * @param list this is the list
    * @param operation this is the operation passed as parameter.It will apply to each parameter.
    * @return This is the new List that will be returned with all result.
    */
  def  performAnMathOperationToEachElements[T](list: List[T]) (operation:(T)=>T): List[T]={

    list match {
      case List()=> Nil
      case (head::tailList)=> operation(head)::performAnMathOperationToEachElements(tailList)(operation)
    }
  }

  /**
    * This method will iterate all elements and filter the elements that does fulfill the filter
    * @param list this the list of elements passed as parameter.
    * @param filterCriteria this is the filter passed as parameter.
    * @tparam T this is the list type.
    * @return this is the new list with all element that fulfill the filter criteria.
    */
  def filterElements[T](list: List[T])(filterCriteria:(T)=>Boolean ): List[T]={

    list match {
    case List()=> Nil
    case (head::tailList) => {
        if (filterCriteria(head)) head::filterElements(tailList)(filterCriteria)
        else filterElements(tailList)(filterCriteria)
      }
    }
  }

}
object testListFuctionExamples{

  def main(args: Array[String]) {

    val list1 = 1::2::Nil
    val list2 = 2::3::1::Nil
    val listFuctionExamples = new ListFuctionExamples

    val filterElements1 = listFuctionExamples.filterElements(list1) ( (parameter:Int)=>parameter >= 2)
    val filterElements2 = listFuctionExamples.filterElements(list2) ( (parameter:Int)=>parameter >= 2)

    println(filterElements1)
    println(filterElements2)

    val performAnMathOperationToEachElements1 =
      listFuctionExamples.performAnMathOperationToEachElements(list1)( (parameter:Int)=> parameter * parameter )

    val performAnMathOperationToEachElements2 =
      listFuctionExamples.performAnMathOperationToEachElements(list2) ( (parameter:Int)=> parameter * parameter)


    println(performAnMathOperationToEachElements1)
    println(performAnMathOperationToEachElements2)




  }


}
