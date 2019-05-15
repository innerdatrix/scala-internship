package supervision
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
class Supervisor02 extends Actor with ActorLogging {
  import akka.actor.AllForOneStrategy
  import akka.actor.SupervisorStrategy._
  import scala.concurrent.duration.DurationLong
  val worker01 = context.actorOf(Props[WorkerActor], name = "worker01")
  val worker02 = context.actorOf(Props[WorkerActor], name = "worker02")   
  override val supervisorStrategy = AllForOneStrategy(
            maxNrOfRetries = 10, withinTimeRange = 10 seconds) {
    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }
  def receive = {
    case result: Result =>
      worker01.tell(result, sender)
    case msg: Object =>
      worker01 ! msg
  }
  override def postStop() {
    log.info("Stopping Supervisor # {}", 
              this.hashCode())
  }
}  