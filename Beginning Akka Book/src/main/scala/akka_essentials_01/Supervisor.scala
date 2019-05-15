package akka_essentials_01

import akka.actor._

object Supervisor extends App
{
  val actorsSystem = ActorSystem("MyFirtActorsSystem")
  val myActor = actorsSystem.actorOf(Props(new MyActor(1)), name="MyActor")
  val yourActor = actorsSystem.actorOf(Props(new YourActor(2)), name="YourActor")
  
  Console println myActor.path
  println(yourActor.path+"\n")
  myActor.tell("Hello", yourActor)
  yourActor.tell("Hi, How are you?", myActor)
  myActor.tell(true, yourActor)
  
  actorsSystem.shutdown()

}