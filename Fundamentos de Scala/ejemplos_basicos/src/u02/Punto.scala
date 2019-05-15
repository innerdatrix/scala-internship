package u02

class Punto(private var x: Double, private var y: Double) {
  def this() = this(0, 0)
  def this(p: Punto) = this(p.getX(), p.getY())
  
  def getX() = x
  def getY() = y
  def setX(x: Double) = this.x = x
  def setY(y: Double) = this.y = y
  
  override def toString = x + "," + y 
}

object PuntoDemo {
  def main(args: Array[String]) {
    var p = new Punto(0,0)
    println(p)
    var q = new Punto(5.5, -6.06)
    println(q)
    var r = new Punto(q)
    r.setY(99.99)
    println(r)
  }
}

// Quitar override y observar qué pasa
// Cambiar main por App

// No funciona por que el main es el punto de entrada para ejecutar
// una aplicacion en Scala
// el override es necesario debido a que se esta modificando la funcion 
// que se esta heredando de forma predeterminada de una superclase o Trait

