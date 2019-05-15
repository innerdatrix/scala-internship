package supervision
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import scala.concurrent.Future
import scala.concurrent.Await
import akka.util.Timeout
import scala.concurrent.duration.DurationLong
case class Result()
object System01 extends App {
  val system = ActorSystem("faultTolerance")
  val log = system.log
  val originalValue: Int = 0;
  val supervisor = system.actorOf(Props[Supervisor01], name = "supervisor")
  implicit val timeout = Timeout(5 seconds)
  // ENVIO DE VALOR ENTERO
  log.info("Sending value 8, no exceptions should be thrown! ")
  var mesg: Int = 8
  supervisor ! mesg
  var future = (supervisor ? new Result).mapTo[Int]
  var result = Await.result(future, timeout.duration)
  log.info("Value Received-> {}", result)
  // ENVIO DE VALOR ENTERO NEGATIVO
  log.info("Sending value -8, ArithmeticException should be thrown! Our Supervisor strategy says resume!")
  mesg = -8
  supervisor ! mesg
  future = (supervisor ? new Result).mapTo[Int]
  result = Await.result(future, timeout.duration)
  log.info("Value Received-> {}", result)
  // ENVIO DE VALOR NULL
  log.info("Sending value null, NullPointerException should be thrown! Our Supervisor strategy says restart !")
  supervisor ! new NullPointerException
  future = (supervisor ? new Result).mapTo[Int]
  result = Await.result(future, timeout.duration)
  log.info("Value Received-> {}", result)
  // ENVIO DE VALOR INVALIDO (STRING)
  log.info("Sending value \"String\", IllegalArgumentException should be thrown ! Our Supervisor strategy says Stop !")
  supervisor ? "Do Something"

  system.shutdown();
}