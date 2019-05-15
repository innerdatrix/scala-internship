package u01

class Punto(private var x : Double, var y : Double)
{
  def this() = this(0.0, 0.0)

  def getx = x
  def gety = y
  def setx(x:Double) = this.x = x
  def sety(y:Double) = this.y = y
}

object Demo_punto
{
  def main(args:Array[String])
  {
    var p01 = new Punto { setx(22.22e22) ; sety(33.33e66)}
    println("Punto 1 : "+p01.getx+" , "+p01.gety)
    var p02 = new Punto {setx(2); y=2*getx} 
    println("Punto 2 : "+p02.getx+" , "+p02.y)
    var p03 = new Punto
    println("Punto 3 : "+p03.getx+" , "+p03.y)
  }
}