package _01

import akka.actor._

class RemoteActor extends Actor {
  override def preStart(){
	println("RemoteActor: "+self.path)		
  }
  
  override def receive: Receive = {
    case msg: String => {
      println("remote received " + msg + " from " + sender)
      sender ! "hi"
    }
    case _ => println("Received unknown msg ")
  }
}