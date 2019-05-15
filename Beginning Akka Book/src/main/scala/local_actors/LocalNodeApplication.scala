package local_actors
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.actor.Props

object LocalNodeApplication {

  def main(args: Array[String]): Unit = {
    // load the configuration
    val config = ConfigFactory.load().getConfig("LocalSys")
    val system = ActorSystem("LocalNodeApp", config)
    val clientActor=system.actorOf(Props[LocalActor], name ="localActor")
    clientActor ! "Hello"
    Thread.sleep(4000)
    system.shutdown()
  }
}