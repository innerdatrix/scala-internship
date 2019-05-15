package u04

trait Semilla {
  def tiene_semilla: Boolean = {
    var x: Double = Math.random
    if(x < 0.5)
      return true
    else
      return false
  }
}