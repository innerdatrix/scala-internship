package u01

class Fruta {
  def getColor = Fruta.color
  def setColor(color:String) = this.color = color
  def imprimeColor() = println (color)
  
  private var color = "azul"
}

object Fruta
{
  var color = "blanco"
}

object Demo_fruta
{
  def main(args:Array[String])
  {
    println(Fruta.color)
    var fresa = new Fruta {setColor("verde")}
    fresa.imprimeColor()
    Fruta.color = "amarillo"
    println(Fruta.color)
  }
}