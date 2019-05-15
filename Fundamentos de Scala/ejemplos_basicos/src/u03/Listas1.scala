package u03

object Listas1 extends App {
  var a = 1::Nil
  var b = 2::a
  var c = 1::2::3::Nil
  var d = "xyz"::"abc"::Nil
  var e = 2::a::Nil
  var f = Nil
  var g = Nil::Nil::5::Nil::"HOLA"::Nil
  var h = Nil::Nil::(5::Nil)::"HOLA"::Nil
  val i = List(1,2,3) 
//  Otra forma de crear una lista
  println(a)
  println(b)
  println(c)
  println(d)
  println(e)
  println(f)
  println(g)
  println(h)
  println(i) 
  
//  Nil es igual a lista vacia cuando se termina con Nil y el tipo de los elementos es String

}