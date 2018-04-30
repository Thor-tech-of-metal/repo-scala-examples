package week7.infinive.loops

/**
  * Created by thor on 26/07/16.
  */
class InfinitiveRepresentation {


  /**
    * This will print all natural numbers from  the first number value
    * @param firstNumber this is the first element of the strem
    * @return stream with all natural numbers.
    */
  def naturalsNumbers(firstNumber:Int): Stream[Int] = firstNumber #:: naturalsNumbers(firstNumber+1)

  /**
    * This method will calculate all prime numbers  for a list of natural numbers.
    * It will do it for each natural number.
    * @param numberList this is the list of natural numbers.
    * @return it will create an list with all prime numbers.
    */
  def sieve (numberList:Stream[Int]): Stream[Int] ={
    numberList.head #:: sieve( numberList.tail.filter( (parameter:Int)=>parameter % numberList.head != 0  ) )
  }

  def sqrSream(number: Double) : Stream[Double] ={

    def improve(guess:Double) = (guess + number /guess) / 2

    lazy val allGuesses: Stream[Double] = 1 #:: (allGuesses map improve  )
    allGuesses
  }

  def isGoodEnough(guess:Double, x:Double) = math.abs((guess * guess -x)/x ) < 0.0001
}

object  InfinitiveRepresentationTest{

  def main(args: Array[String]) {

    val infinitiveRepresentation = new InfinitiveRepresentation
    val numbersFromZero = infinitiveRepresentation.naturalsNumbers(0)
    val naturalsMultipleOf4= numbersFromZero map (_* 4)
    val primers  = infinitiveRepresentation.sieve(( infinitiveRepresentation.naturalsNumbers(2)))
    val sqrOf4= infinitiveRepresentation.sqrSream(4)


    println(numbersFromZero)
    println(numbersFromZero.take(10).toList)
    println(naturalsMultipleOf4)

    // we only take the fist 100 this is when the lazy "#::"  is executed
    println(primers.take(100).toList)
    // It will get the first 10 sqrOf4 with are good enough
    println(sqrOf4.filter( infinitiveRepresentation.isGoodEnough(_,4)).take(10).toList)

  }
}