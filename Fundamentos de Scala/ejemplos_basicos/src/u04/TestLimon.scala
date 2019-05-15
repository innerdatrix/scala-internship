package u04

object TestLimon extends App {
  var li = new Limon
  println("Precio: " + li.precio)
  println("Color : " + li.color)
  println("Sabor : " + li.tiene_sabor)
  println("¿Tiene semilla? " + li.tiene_semilla)
  //Polimorfismo
  var f1: Fruta = new Limon
  var f2: Degustacion = new Limon
  println("Sabor " + f2.tiene_sabor)
  var f3: Semilla = new Limon
  if(f3.tiene_semilla) println("Tiene Semilla")
}