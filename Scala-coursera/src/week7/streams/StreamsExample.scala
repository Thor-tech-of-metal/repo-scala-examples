package week7.streams

import scala.collection.immutable.Stream.cons

/**
  * Created by thor on 25/07/16.
  */
class StreamsExample {


  def filterMyStream [T] ( stream:Stream[T],functionFilter: T => Boolean): Stream[T]={

    if (stream.isEmpty) Stream.empty
    else if (functionFilter(stream.head)) Stream.cons(stream.head, filterMyStream(stream.tail, functionFilter))
    else filterMyStream(stream.tail,functionFilter)
  }

  def printBasedOnCondition[T] ( stream:Stream[T],functionFilter: T => Boolean):Unit={

    if (stream.isEmpty) println(Stream.empty)

    else if (functionFilter(stream.head)){
              println(stream.head )
              this.printBasedOnCondition(stream.tail,functionFilter)
    }
    else printBasedOnCondition(stream.tail,functionFilter)
  }


}
object StreamsExampleTest{


  def main(args: Array[String]) {

    val streamsExample =  new StreamsExample
    val streamTest = Stream(1,3,5,6)
    var result = streamsExample.filterMyStream[Int](streamTest , (parameter:Int)=> parameter > 2 )

    streamsExample.printBasedOnCondition(result,(parameter:Int)=> parameter > 1 )
    println(result.toList)
  }

}
