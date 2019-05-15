package u03

object Funciones1 extends App {
  def E(x: Float) = {
    def F(y: Float) = x + y
    F(2 * x)
  }
  
  println(E(5)) //¿Cuál es la salida?
}