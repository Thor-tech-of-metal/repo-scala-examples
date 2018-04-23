package com.thor.tech.examples.lang.currying;

case object Currying {

  def nocurrysum(x:Int, y:Int, z:Int) = x + y + z

  def currysum(x:Int)(y:Int)(z:Int) = x + y + z

  val currysum2 = (x: Int) => (y: Int) => (z: Int) => x + y + z

  val currysum3: Int => Int => Int => Int = x => y => z => x + y + z

  val currysum4 = (x: Int) => (y: Int) => (z: Int) => nocurrysum(x, y, z)

  def main(args: Array[String]): Unit = {

    val res = Currying.currysum(2)(3)(4)
    val res1 = Currying.currysum2(2)(3)
    val res2 = Currying.currysum2(2)(3)(4)
    val res3 = Currying.currysum3(2)(3)(4)
    val res4a = (Currying currysum4 2)
    val res4b = res4a(3)
    val res4 = res4b(4)
    val res5 = Currying.nocurrysum(2, 3, 4)
    val resno = ((Currying.nocurrysum(2, _:Int, _:Int))(3, _:Int))(4)

    println(res)
    println(res1)
    println(res2)
    println(res3)
    println(res4)
    println(res5)
    println(resno)
  }
}
