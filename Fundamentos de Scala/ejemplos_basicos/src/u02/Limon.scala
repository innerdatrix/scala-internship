package u02

class Limon extends Fruta {
  var color = "amarillo"
  override def precio() = .99
}

object Limon {
  def main(x: Array[String]) {
    var limon = new Limon
    print("Costo: " + limon.precio)
    println(" color: " + limon.color)
  }
}

/* Odersky p.327 - 328
Inheritance means that all members of the superclass are also members
of the subclass, with two exceptions. 
First, private members of the superclass are not inherited in a subclass.
Second, a member of a superclass is not inherited if a member with the same
name and parameters is already implemented in the subclass.
In that case we say the member of the subclass overrides the member of the superclass. 
If the member in the subclass is concrete and the member of the superclass is abstract,
we also say that the concrete member implements the abstract one.
*/