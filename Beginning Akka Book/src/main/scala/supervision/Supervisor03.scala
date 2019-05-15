package supervision
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import scala.concurrent.duration.DurationLong

class SupervisorActor03 extends Actor with ActorLogging {
  var childActor = context.actorOf(Props[Worker01], name = "workerActor")
  val monitor = context.system.actorOf(Props[MonitorActor], name = "monitor")
  override def preStart() {
    monitor ! new RegisterWorker(childActor, self)
    log.info("Starting Supervisor")
  }
  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 10 seconds) {
    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }
  def receive = {
    case result: Result =>
      childActor.tell(result, sender)
    case mesg: DeadWorker =>
      log.info("Got a DeadWorker message, restarting the worker")
      childActor = context.actorOf(Props[WorkerActor], name = "workerActor")
    case msg: Object =>
      childActor ! msg
  }
  override def postStop(){
    log.info("ShuttingDown Supervisor")
  }
}