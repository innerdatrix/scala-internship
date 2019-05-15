package ch13

class Rocket {
  //import Rocket.fuel
  private def canGoHomeAgain = Rocket.fuel > 20
  private val maxSpeed = 95
}

object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket) {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }
  def goHome() {}
  def pickAStar() {}
  val rock = new Rocket
  println(rock.maxSpeed)
}

object Street
{
  def main(args : Array[String])
  {
    val rock00 = new Rocket
    val rock01 = Rocket
  }
}
