package u02

class Circulo(private var c: Punto, private var r: Double) {
  def this() = this(new Punto, 1)
  def this(x: Double, y: Double, r: Double) = this(new Punto(x, y), r)

  def getX = c.getX()
  def getY = c.getY()
  def getR = r
  def setX(x: Double) = c.setX(x)
  def setY(y: Double) = c.setY(y)
  def setR(r: Double) = this.r = r

  override def toString = "\n\t    Circulo\n      Centro\t   Radio\n [" + c + "]-----[" + r + "]\n"
}

object CirculoDemo {
  def main(args: Array[String])
  {
    println(new Circulo(-4.002, 5.55, 5))
    var p = new Punto(22, 33)
    println(new Circulo(p, 44))
    println(new Circulo())
  }
}

//Utilizar los otros dos contructores
//Verificar porqué cambia el orden de salida si es imperarivo versus funcional