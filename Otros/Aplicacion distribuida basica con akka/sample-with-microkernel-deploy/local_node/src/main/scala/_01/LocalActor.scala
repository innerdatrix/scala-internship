package _01

import akka.actor._

class LocalActor extends Actor{
  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
	println("LocalActor: "+self.path)	
    val remoteActor = context.actorSelection("akka.tcp://RemoteSystem@127.0.0.1:5150/user/RemoteActor")
    println("That 's remote:" + remoteActor)
    remoteActor ! "hi"
  }
 
  override def receive: Receive = {
    case msg:String => {
      println("got message from remote" + msg)
    }
  }
}