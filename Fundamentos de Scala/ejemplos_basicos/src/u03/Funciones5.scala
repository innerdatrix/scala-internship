package u03

object Funciones5 extends App {
  //Ejemplo 1
  var m = 5 
  var inc5 = (x: Int) => x + m 
  //bound: something that limits or restraints
  println(inc5(7))
  
  m = 10 // free variable
  println(inc5(7))
  
  //Ejemplo 2
  def fmul(x: Double) = x * 3
  
  //                     fmul             0.1        
  def derivada(f: (Double => Double), dx: Double) 
        = (x: Float) => ( f(x + dx) - f(x) ) / dx
  //           5      fmul(5.1)=15.3 - fmul(5)=15 = .3
  //                              .3 / .1
  
  //(fmul(x + 0.1) - fmul(x))/0.1
  var der = derivada(fmul, 0.1)
  
  //  var der2 = derivada(((x: Double) => x * 3), 0.1)
  println(der(5))
  
  //Ejemplo 3
  def saludar(n: String): Unit = return println("Hola " + n)
  saludar("Ulises")
  
  //Ejemplo 4
  val f = (x: Int) => x + 1
  val g = (x: Int) => x * 3.3
  val h = (x: Double) => x + 0.1
  var resultado =  h compose g compose f
  println(resultado(4))
  var resultado2 = h(g(f(4)))
  println(resultado2)
}