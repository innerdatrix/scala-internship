package futures

import akka.actor.Actor

class Actor2 extends Actor{
  import futures.FunFut.facto
  def fact(num:BigInt) = facto(num)
  def receive = {
    case num:BigInt => sender ! fact(num); println(self+" done! ");
    case _ => println(self+" :(")
  }
}
