package u03

object Listas2 extends App {
  var a = List(1)
  var b = List(2,1)
  var c = List(1,2,3)
  var d = List("xyz","abc")
  
//  println(a)
//  println(b)
//  println(c)
//  println(d)
  
  var n = 25
  var x = 65
  
  var nlist = List("") 
  var z = List("")
  
  for (k <- 0 to n ){
       z = List(x.toChar.toString())
       nlist = nlist ::: z
       x += 1 
  }
  
  print("---")
  nlist.foreach(println)
  println("---")
}
//¿Cómo crear una lista de n elementos?
