package u02

class Limon2 extends Fruta {
  def color = "amarillo"
  override def precio() = (super.precio ) / 2
}

object Limon2Demo {
  def main(a: Array[String]) {
    var f = new Fruta
    var l = new Limon2
    println("Fruta: " + f.precio)
    println("Limón: " + l.precio)
    
    f = l //upcasting
    
    println("Fruta: " + f.precio)
    println("Limón: " + l.precio)
  }
}