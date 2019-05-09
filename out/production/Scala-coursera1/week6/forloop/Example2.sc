object Example2 {

  //This will iterate all elements produce x1 + y1 and select the results which are prime
  //       i 0 1 2 3
  //       j 0 1 2 3
  // IndexedSeq[(Int, Int)] = Vector((2,1), (3,1), (3,2))




val n = 4

/*(1 until n).
  flatMap( i=> (1 until i) map (j => (i,j)) ).
  filter(pair=> {isPrime( pair._1 + pair._2 )})
*/


}