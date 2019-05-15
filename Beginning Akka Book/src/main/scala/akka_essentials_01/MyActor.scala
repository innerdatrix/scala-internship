package akka_essentials_01

// 2. importar biblioteca de actores de akka
import akka.actor._

// 1. actor basico
class MyActor(id :Int) extends Actor with ActorLogging
{
 
  // 3. recepcion de mensajes
  def receive = 
  {
    // 4. Definicion de patrones
    case message :String => println("["+id+"]"+"Message Received: "+message)
    case uhhCrazy :Boolean => sender.forward("what??")
    case _ => println("<...???...>") ; log.info(context.sender.toString())
  }
  //context.stop(self)
  //case object MiObjeto01...
  override def  preStart()
  {
    println("["+id+"]"+"arriving...")
  }
  
  override def postStop()
  {
    println("["+id+"]"+"Goodbye")
  }

  //val childActor = context.actorOf(Props[YourActor], "childActor")
}