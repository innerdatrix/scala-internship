package u04

class ClassImpl extends Clase with Trait2 with Trait1 {
  override def m = "Bye" + super.m
  //  override def m = 1000
}

object Test extends App {
  var c: ClassImpl = new ClassImpl
  println(c.m)
}