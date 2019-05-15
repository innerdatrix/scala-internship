package u03

import Array._

object Arreglos2 extends App {
  
  var a = ofDim[String](3, 3)
  
  for (j <- 0 to a.length - 1)
      for (k <- 0 to a(j).length - 1)
        println(a(j)(k))

  var b = ofDim[Int](3, 3, 3)

  for (i <- 0 to b.length - 1)
    for (j <- 0 to b(i).length - 1)
      for (k <- 0 to b(i)(j).length - 1)
        println(b(i)(j)(k))

  var c = ofDim[Int](3, 3, 3)

  for (i <- 0 to c.length - 1)
    for (j <- 0 to c(i).length - 1)
      for (k <- 0 to c(i)(j).length - 1)
        println(c(i)(j)(k))
}