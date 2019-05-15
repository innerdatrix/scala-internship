package ch13

// In file bobsdelights/package.scala
package object ch13 {
  def showFruit(fruit: Fruit) {
    import fruit._
    println(name +"s are "+ color)
  }
}

abstract class Fruit(
   val name: String,
   val color: String
)
{
  override def toString = name + " " + color 
}
  
object Fruits{
   object Apple extends Fruit("apple", "red")
   object Orange extends Fruit("orange", "orange")
   object Pear extends Fruit("pear", "yellowish")
   val menu = List(Apple, Orange, Pear)
}

