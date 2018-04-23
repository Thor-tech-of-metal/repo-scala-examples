//Fold left goes through the list an associate from left to right and put the result in the accumulator
// ( (1+2) +3 )+4
var list = List(1,2,3,4)
list.foldLeft(0)((b,a) => b+a)
list.foldLeft(List[Int]())((b,a) => a :: b)

(0.to(3).foldLeft(List[Int]()) ( (x, xs) => xs ::x ) )

//Fold Right goes through the list an associate from Right to left and put the result in the accumulator
//1 + (2 + (3 +4 ) )
(0.to(3).foldRight(List[Int]()) ( (x, xs) => x :: xs) )