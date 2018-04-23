def add3(x: Int) (y: Int) (z: Int)={  x+y+z  }

def add1(x: Int): (Int => Int) = {
  (y: Int) => { x + y }
}
add1(1).apply(1)
add1(1)(1)

def * = (a:Int) => (b:Int) => a * b
val timesthree = *(3)
timesthree(4)

add3(1)(1)(1)


