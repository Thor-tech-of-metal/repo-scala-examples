object Example1{

  def scalarProduct ( vector1: Vector[Double], vector2: Vector[Double]) :Double={

    //zip return a collection of pairs like this one List((1,3),(2,3))
    // Map perform the function f= pair._1 * pair._2 to each list elemt of type pair
    // pair pair._1 * pair._2
    //.sum sum the resul of each function result f()
    vector1.zip(vector2).map(pair=>pair._1 * pair._2).sum
  }


  def scalarProductPatterMatching ( vector1: Vector[Double], vector2: Vector[Double]) :Double={

    //zip return a collection of pairs like this one List((1,3),(2,3))
    // Map perform the code that patternMatching each pairs values x,y and perform x*y
    //.sum sum the resul of each function result f()
    vector1.zip(vector2).map( { case (x,y)=> x * y} ).sum
  }


  /**
    * This function will return all element that are prime of number
    * @param number this is the number
    * @return a list with all primes
    */
  def isPrime(number:Int):Boolean={

    (2 until number).forall(d => d%number!=0 )
  }

  //Array example.
  val array=Array(1,2,3,44)
  array map (parameter=>parameter*2)

  //Sequences examples
  val sequence="Hello Wordl"
  //get all upper case elements
  sequence filter (parameter=>parameter.isUpper)

  //It checks if at least one element exist with the condition.
  sequence exists(parameter=>parameter.isUpper)

  //It checks if all elements follow the condition passed as parameter.
  sequence forall  (parameter=>parameter.isUpper)

  // takes two sequences and creatre a single sequence of pairs
  val pair = List(1,2,3) zip sequence
  //creates two lists with the the sparated pair elements
  pair.unzip

  // flatMap works applying a function that returns a sequencefor
  // each element in the list, and flattening the results into the
  // original list.

  //It will iterate each elelemt if sequence and apply the function and
  //concatenate the result in a new list of type function element result of
  // each element.
  sequence flatMap(parameter=> List(".",parameter))


}

