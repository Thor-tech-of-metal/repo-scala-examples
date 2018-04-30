package week5.collection.example.covariance

/**
  * Created by thor on 15/08/16.
  */
class NumbersCovariant [-A]{

  def  sumAnyType[B <: A](list: List[B], zero:B )(operation:(B,B)=>B): B={

    list match {
      case Nil=> zero
      case (head::tailList)=> operation( head , sumAnyType(tailList,zero)(operation) )
    }
  }

}
object numbersCovariantList{

  def main(args: Array[String]) {

    val list1 = 1::2::Nil
    val list2 = 2.0::3.2::1.1::Nil
    val list3 = "2"::"3"::Nil
    val covarianceContravariantList = new NumbersCovariant[AnyVal]

    var sumInt = covarianceContravariantList .sumAnyType(list1,0) ((parameter1:Int, parameter2:Int)=> parameter1+ parameter2 )
    var sumDouble = covarianceContravariantList .sumAnyType(list2,0.0) ((parameter1:Double, parameter2:Double)=> parameter1+ parameter2 )

    //Error:(29, 50) inferred type arguments [String] do not conform to method sumAnyType's type parameter bounds [B <: AnyVal]
    //var sumString = covarianceContravariantList .sumAnyType(list3,"0") ((parameter1:String, parameter2:String)=> parameter1+ parameter2 )

    println(sumInt)
    println(sumDouble)
  }
}