package u03

object Arreglos1 extends App {
  var a1 = new Array[Int](3)
  a1(1) = 6
  a1(2) = 71
  println(a1(1))
  
  var a2 = new Array[String](5)
  a2(0) = "Java"
  a2(4) = "Scala"
  println(a2(0))
  
  var a3 = Array("Uno", "Dos", "Tres")
  println(a3(2))
  
  //for(s <- a2) println(s)
  //for(i <- a1) println(i)
  
//  val arrbid = new Array[String](2)(2)
//  for(x <- arrbid)
//  {
//    println(x)
//    for(y <- arrbid)
//        println(y)
//  }
  
}

//¿Cómo se hace un arreglo bidimensional?