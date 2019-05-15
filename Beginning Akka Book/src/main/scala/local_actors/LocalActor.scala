package local_actors
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Address
import akka.actor.Deploy
import akka.actor.Props
import scala.concurrent.Await
import akka.pattern.ask
import akka.remote.RemoteScope
import scala.concurrent.duration.DurationInt
import akka.util.Timeout

class LocalActor extends Actor with ActorLogging {
  //Get a reference to the remote actor
  val remoteActor = context.actorSelection("akka://RemoteNodeApp@192.168.0.3:2553/user/remoteActor")
  implicit val timeout = Timeout(5 seconds)
  def receive: Receive = {
    case message: String =>
      val future = (remoteActor ? message).mapTo[String]
      val result = Await.result(future, timeout.duration)
      log.info("Message received from Server -> {}", result)
  }
}