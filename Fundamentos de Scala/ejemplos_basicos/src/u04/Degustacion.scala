package u04

//Trait = clase que define un número de métodos y/o campos
//        pero que no puede utilizarse sola
//Un tratit se puede mezclar con las clases
//Se utilizan para extender el comportamiento de las clases y de otros traits

trait Degustacion {
  var sabor = "agrio"
  def tiene_sabor(): String = {
    return sabor
  }
  def asignar_sabor(sabor: String) = {
    this sabor = sabor //la omisión del operador . aplica también en clases
  }
}