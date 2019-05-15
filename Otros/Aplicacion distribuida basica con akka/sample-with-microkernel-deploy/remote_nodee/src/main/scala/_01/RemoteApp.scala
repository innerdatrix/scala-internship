
package _01

import akka.kernel.Bootable
import akka.actor.ActorSystem
import akka.actor.Props
import com.typesafe.config.ConfigFactory

class RemoteApp extends Bootable {
  val system = ActorSystem("RemoteSystem" , ConfigFactory.load())
  val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor")

  def startup = {
    
  }

  def shutdown = {
    system.shutdown()
  }
}

object RemoteApp{
  def main(args: Array[String]){
	val remote = new RemoteApp
    println("remote is ready...")
  }
}