package ch12

/*
 * Once a trait is deﬁned, it can be mixed in to a class using either the
 * extends or with keywords. 
 * ... mixing in a trait has important differences from
 * the multiple inheritance found in many other languages. 
 */

//mix: combinar, agregar
//in: localizado dentro con algo mas - llegar y entrar dentro de algo
//mixin!! ... con la palabra: with (tantos como el num de traits)
// extend: extiende una superclase
// 
class Frog extends Animal with filosofia
{
  override def toString = "verde" 
  override def pensar{
    println("O no es facil ser "+ toString +"!")
  }
}
/*
 * You can use the extends keyword to mix in a trait; in that case you
 * implicitly inherit the trait’s superclass.
 * 
 * Methods inherited from a trait can be used just like methods inherited
 *  from a superclass.
 */
 
object ejecuta 
{
  def main(args: Array[String])
  {
    val frog = new Frog
    
/*
 * variable fil could have been initialized with any 
 * object whose class mixes in Philosophical
 * La variable fil pudo haber sido inicializada con cualquier
 * objeto que la clase "mixes" de filosofia (dentro de la clase frog)
 */
 
    val fil: filosofia = frog
    println(frog)
    println(frog.pensar)
    println(fil.pensar)
  }
}
