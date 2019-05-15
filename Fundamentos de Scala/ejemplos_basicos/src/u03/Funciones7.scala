package u03

object Funciones7 extends App {
  //Ejemplo 1
  def factorial(n: Int): BigInt =
    if(n == 0) 1 else n * factorial(n - 1)
    
  class Factorizar(n: Int) {
      def ! = factorial(n)
  }
  
  implicit def f(n: Int) = new Factorizar(n)
  
  println(5!)
  
  
  //Ejemplo 2
  def sumatoria(n: Int): Int = n + n + n
  
  class Sumar(n: Int) {
    def +++ = sumatoria(n)
  }
  
  implicit def s(n: Int) = new Sumar(n)
  
  println(4+++);
  
//  f(x) = x^2
//  println(x')
}

//Conversión de tipo implícita = polimorfismo