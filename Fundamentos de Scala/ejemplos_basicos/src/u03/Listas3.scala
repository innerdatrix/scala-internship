package u03

object Listas3 extends App {
  var a: List[Int] = Nil
  println(a)

  for (i <- 10 to 1 by -1)
    a = i :: a
  println(a)

  println(a.tail)
  println(a.head)

  //Estilo imperativo
  def longitud(a: List[Int]): Int =
    if (a.isEmpty)
      0
    else
      1 + longitud(a.tail)

  //Estilo funcional
  def longitud2(a: List[Int]): Int =
    a match {
      case Nil => 0
      case x :: xs => 1 + longitud2(xs)
      // List(1,2,3,4,5)
      // x = 1              --- a.head = x
      // xs = List(2,3,4,5) --- a.tail = xs
    }
  
  println(longitud(a))
  println(longitud2(a))
}