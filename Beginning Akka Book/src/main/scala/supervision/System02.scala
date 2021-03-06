package supervision
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import scala.concurrent.duration.DurationLong
import scala.concurrent.Future
import scala.concurrent.Await
import akka.util.Timeout
object System02 extends App {
val system = ActorSystem("faultTolerance")
  val log = system.log
  val originalValue: Int = 0;
  val supervisor = system.actorOf(Props[Supervisor02], name = "supervisor")

  log.info("Sending value 8, no exceptions should be thrown! ");
  var mesg: Int = 8;
  supervisor ! mesg

  implicit val timeout = Timeout(5 seconds)
  var future = supervisor ? new Result
  var result = Await.result(future, timeout.duration).asInstanceOf[Int]
  log.info("Value Received->" + result)

  log.info("Sending value -8, ArithmeticException should be thrown! Our Supervisor strategy says resume !")
  mesg = -8
  supervisor ! mesg
  future = supervisor ? new Result
  result = Await.result(future, timeout.duration).asInstanceOf[Int]
  log.info("Value Received->" + result)
  
  log.info("Sending value null, NullPointerException should be thrown! Our Supervisor strategy says restart !")
  supervisor ! new NullPointerException
  future = supervisor ? new Result
  result = Await.result(future, timeout.duration).asInstanceOf[Integer]
  log.info("Value Received->" + result)
  
  log.info("Sending value \"String\", IllegalArgumentException should be thrown! Our Supervisor strategy says Stop !")
  supervisor ? "Do Something"
  future = supervisor ? new Result
  result = Await.result(future, timeout.duration).asInstanceOf[Int]
  log.info("Value Received->" + result)

  system.shutdown();
}