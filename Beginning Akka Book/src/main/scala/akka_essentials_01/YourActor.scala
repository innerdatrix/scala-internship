package akka_essentials_01

import akka.actor._

class YourActor(id :Int) extends Actor 
{
  def receive = 
  {
    case message :String => println("["+id+"]"+"Message Received: "+message)
    case uhhCrazy :Boolean => {sender() ! "what???"}
    case _ => {println("<...???...>"); self.tell("what???", sender);}  
  }

  override def  preStart()
  {
    println("["+id+"]"+"arriving...")
  }
  
  override def postStop()
  {
    println("["+id+"]"+"Some..body shootth!...me")
  }
}