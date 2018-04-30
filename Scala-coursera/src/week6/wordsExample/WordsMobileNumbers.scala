package week6.wordsExample

import scala.io.Source

/**
  * Created by thor on 22/07/16.
  */
class WordsMobileNumbers {

  /* read a file of words */
  //val input = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")


  val words = createWords()
  /* define the map of numbers to letters */
  val nmem = Map( '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  /* invert the map the get a map of letters to digits */
  val charCode: Map[Char, Char] = for  ( (digit,letterCombination) <-nmem ; letter <- letterCombination ) yield letter-> digit

   /** methods**/

  def createWords(): List[String]={
    val input = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
     /* create a list and filter all words where *all* their characters are not letters (like dashes) */
    val words = input.getLines.toList filter (word => word forall (chr => chr.isLetter))
    return words
  }

  /* define a function that returns the numbers of a given word */
  // For example java -> 5282
  // charCode is a map and a map is also a function hence wil can apply a map()
  // and pass as function parameter charCode. Simple because charCode is a f() too. \m/
  def wordCode(word: String): String = word.toUpperCase map charCode

  /** Group all words of our long list with the same number
    * for a given number It will match with all words combinations.
    * 5282 --> List(java,kata,lava)
    *
    * words groupBy wordCode withDefaultValue Seq()
    * // apply a groupBy and use as key each element of the result call of wordCode map.
    * Where each call uses "words[index]" as parameters. wordCode("words[index]")
    * */
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()

  /** Group all words of our long list with the same number
    * for a given number It will match with all words combinations.
    * 5282 --> List(java,kata,lava)
    *
    * words groupBy wordCode withDefaultValue Seq()
    * // apply a groupBy and use as key each element of the result call of wordCode map.
    * Where each call uses "words[index]" as parameters. wordCode("words[index]")
    * All of that return a hashMap with default value.
    * */
  val wordsForNumMoreLines: Map[String, Seq[String]] = words.groupBy(wordCode) withDefaultValue Seq()


  /* function that receives a number and finds the words that match it */
  def encode(number: String): Set[List[String]] =
    // if number is empty "the nothing"
    if (number.isEmpty) Set(List())
    else {
      for {
        eachNumber <- 1 to number.length // iterate over the number
        // take a value from the "wordsForNum" map using the (number take eachNumber) as key.
        // It will skip get that does not respond with any word.
        word <- wordsForNum(number take eachNumber)
        //once we have a word it will get the rest of words by doing a recursive function encode() of the (number take eachNumber).
        // (number take eachNumber) is the rest of the numbers. For example: 123555. if 123 -> hola then the rest on numbers is 555
        // the result of encode(number drop eachNumber) is the rest of the words that match with 555
        rest <- encode(number drop eachNumber)
      }
        yield word :: rest // join the results
    }.toSet // pass a set to the for


  /* better print of the results */
  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")

}

object WordsMobileNumbersTest{

  def main(args: Array[String]) {
    val wordsMobileNumbers = new WordsMobileNumbers
    /* test the translate and print results*/
    val result=wordsMobileNumbers.translate("7225247386")
    val wordsForNumResult=wordsMobileNumbers.wordsForNum("5282")
    val wordsForNumMoreLinesResult= wordsMobileNumbers.wordsForNumMoreLines("5282");

    println(result)
    println(wordsForNumResult)
    println(wordsForNumMoreLinesResult)

  }
}
