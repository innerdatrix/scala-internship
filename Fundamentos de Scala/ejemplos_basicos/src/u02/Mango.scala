package u02

object Mango {
  def main(args: Array[String]) {
    var m = new Fruta { //clase anónima
      var color = "verde"
      override def precio = 0.7
    }
    m.color="amarillo"
    println("Mango " + m.color)
    println("Costo: " + m.precio)
  }
}

// Odersky, p.826
//anonymous class An anonymous class is a synthetic subclass generated by
//the Scala compiler from a new expression in which the class or trait
//name is followed by curly braces. The curly braces contains the body
//of the anonymous subclass, which may be empty. However, if the
//name following new refers to a trait or class that contains abstract
//members, these must be made concrete inside the curly braces that
//deﬁne the body of the anonymous subclass.

