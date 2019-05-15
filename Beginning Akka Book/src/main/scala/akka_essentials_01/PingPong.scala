package akka_essentials_01

import akka.actor._
import com.typesafe.config._

sealed class PP
case class PING() extends PP
case class PONG() extends PP

class PingPong extends Actor{
  import context._ 
  var count = 0
  def receive: Receive = {
    case PING =>
      println("PING")
      count = count + 1
      Thread.sleep(900)
      self ! PONG
             become{
                   case PONG =>
                   println("PONG")
                   count = count + 1
                   Thread.sleep(900)
                   self ! PING
                   unbecome()
             }
      if(count > 10) context.stop(self)
  }
}

object PingPong extends App
{
  val system = ActorSystem("PingPong_SYS")
  val pingPong = system.actorOf(Props[PingPong], "PingPong")
  pingPong ! PING
}