
package _01

import akka.actor.{Props, Actor, ActorSystem}
import akka.kernel.Bootable
import com.typesafe.config.ConfigFactory
import java.io.File

class LocalApp extends Bootable{

  val system = ActorSystem("ClientSystem", ConfigFactory.load())
  val localActor = system.actorOf(Props[LocalActor], name="LocalActor")
  
  def startup = {

  }

  def shutdown = {
    system.shutdown()
  }
}

object LocalApp{
  def main(args: Array[String]) {
	val localActor = new LocalApp
	println("Local System created...")
  }
}