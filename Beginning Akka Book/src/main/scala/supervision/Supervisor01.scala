package supervision
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import scala.concurrent.duration.DurationLong
class Supervisor01 extends Actor with ActorLogging {
  val childActor = context.actorOf(Props[WorkerActor], 
                                   name = "workerActor")  
  override val supervisorStrategy = OneForOneStrategy(
            maxNrOfRetries = 10, withinTimeRange = 10 seconds) {
    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => println("Escalating..."); Escalate
  }
  def receive = {
    case result: Result =>
      childActor.tell(result, sender)
    case msg: Object =>
      childActor ! msg
  }
  override def postStop() {
    log.info("Stopping Supervisor # {}", 
              this.hashCode())
  }
}                               