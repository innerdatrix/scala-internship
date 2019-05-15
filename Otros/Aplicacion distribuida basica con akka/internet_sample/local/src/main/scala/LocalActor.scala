import java.io.File
import akka.actor.{Props, Actor, ActorSystem}
import com.typesafe.config.ConfigFactory

class LocalActor extends Actor{
  override def preStart(): Unit = {
    val remoteActor = context.actorSelection("akka.tcp://RemoteSystem@127.0.0.1:5150/user/remoteActor")
    println("That 's remote:" + remoteActor)
    remoteActor ! "hi!"
  }
  override def receive: Receive = {
    case msg:String => {
      println("message received: [" + msg + "] from " + sender)
    }
  }
}
object LocalActor {
  def main(args: Array[String]) {
    val configFile = getClass.getClassLoader.getResource("local.conf").getFile
    val config = ConfigFactory.parseFile(new File(configFile))
    val system = ActorSystem("ClientSystem",config)
    val localActor = system.actorOf(Props[LocalActor], name="local")
  }
}