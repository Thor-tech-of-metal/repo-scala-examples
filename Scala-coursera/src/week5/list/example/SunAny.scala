package week5.list.example


/**
  * Created by thor on 11/08/16.
  */
class SunAny {

  def  sumAnyType[T](list: List[T], zero:T )(operation:(T,T)=>T): T={

    list match {
      case Nil=> zero
      case (head::tailList)=> operation( head , sumAnyType(tailList,zero)(operation) )
    }
  }
}

object containerList{

  def main(args: Array[String]) {

    val list1 = 1::2::Nil
    val list2 = 2.0::3.2::1.1::Nil
    val covarianceContravariantList = new SunAny
    val list3 = "2"::"3"::Nil

    var sumInt = covarianceContravariantList .sumAnyType(list1,0) ((parameter1:Int, parameter2:Int)=> parameter1+ parameter2 )
    var sumDouble = covarianceContravariantList .sumAnyType(list2,0.0) ((parameter1:Double, parameter2:Double)=> parameter1+ parameter2 )
    var sumString = covarianceContravariantList .sumAnyType(list3,"0") ((parameter1:String, parameter2:String)=> parameter1+ parameter2 )

    println(sumInt)
    println(sumDouble)
    println(sumString)
  }
}