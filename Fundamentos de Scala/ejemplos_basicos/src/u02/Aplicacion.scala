package u02

object Aplicacion extends App { //App es un Trait
  override def main (args: Array[String]) = println("Aplicación en Scala");
}


//¿Se puede trabajar con una clase?

// Odersky p.112
//To run a Scala program, you must supply the name of a standalone singleton
//object with a main method that takes one parameter, an Array[String],
//and has a result type of Unit. Any standalone object with a main method of
//the proper signature can be used as the entry point into an application.