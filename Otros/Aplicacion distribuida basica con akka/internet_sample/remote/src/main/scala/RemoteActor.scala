import java.io.File
import akka.actor._
import com.typesafe.config.ConfigFactory

class RemoteActor extends Actor {
  override def preStart(){
    println("RemoteActor: "+self.path)
  }
  override def receive: Receive = {
    case msg: String => {
      println("localActor message received: [" + msg + "] from " + sender)
      sender ! "hi"
    }
    case _ => println("Received unknown msg ")
  }
}

object RemoteActor{
  def main(args: Array[String]) {
    //get the configuration file from classpath
    val configFile = getClass.getClassLoader.getResource("remote.conf").getFile
    //parse the config
    val config = ConfigFactory.parseFile(new File(configFile))
    //create an actor system with that config
    val system = ActorSystem("RemoteSystem" , config)
    //create a remote actor from actorSystem
    val remote = system.actorOf(Props[RemoteActor], name="remoteActor")
    println("Remote node is ready")
  }
}