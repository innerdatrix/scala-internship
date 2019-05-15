package u03

object Funciones2 extends App {
  var a: Int = 1;
  def P = {
    var b = 1
    def Q = {
      var b = " b "; var c = 4
      println(a + b + c)
    }
    println(a + b)
  }
}