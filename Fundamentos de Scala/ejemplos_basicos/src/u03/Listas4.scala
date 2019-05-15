package u03

object Listas4 extends App {
  var A: List[Int] = Nil 
  for (i <- 15 to 1 by -1)
      A = i :: A
  println(A)
//  println(A.remove(x => x % 2 == 0)) // ACTUALIZAR
  println(A.takeWhile(e => e % 3 != 0))
  println(A.dropWhile(e => e % 3 != 0))

  var B = A.reverse.tail.reverse
  println(B)

  class Casa(n: Int) {
    override def toString = "Casa " + n
  }
//  var C = new Casa(1) :: new Casa(2) :: new Casa(3) 
//            :: new Casa(4) :: Nil
//  println(C)
//  C = C.tail
//  println(C)
//
//  var D = A.take(5)
//  println(D)
//  D = A.takeRight(5)
//  println(D)
}