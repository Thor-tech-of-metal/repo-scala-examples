object testListMethods{

  val number = List(1,3,4,-1)

  number filter (x=> x>0)
  number filterNot  (x=> x>0)
  number partition (x=> x>0)

  number takeWhile  (x=> x>0)
  number dropWhile (x=> x>0)

  number span  (x=> x>0)

}