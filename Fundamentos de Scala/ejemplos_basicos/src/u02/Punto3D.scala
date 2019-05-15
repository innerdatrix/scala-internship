package u02

class Punto3D(x: Double, y: Double, private var z: Double) extends Punto(y, x) {
  def this() = this(0, 0, 0)
  def this(p: Punto, z: Double) = this(p.getX(), p.getY(), z)
  
  def getZ() = z;
  def setZ(z: Double) = this.z = z
  
  override def toString = super.toString + "," + z
}

object Punt3DDemo {
  def main(args: Array[String]) = println(new Punto3D(4, -0.27, 1))
}

//¿Qué pasa si se quita x,y de la súper clase (después del extends)?
//  segun como se pasen o no los parametros, el constructor de parametro
//  respodera como corresponde, asignando los valores a x y y

//Invertir el orden de x,y: Punto(y,x) y observar lo que sucede
//	  Sin importar el nombre de la variable y su valor, el constructor
//    tiene un orden de asignacion de esos valores a sus miembros, por lo
//    que naturalmente el unico cambio es el valor de la variable que se 
//    pasa en determinada posicion dentro de los parametros