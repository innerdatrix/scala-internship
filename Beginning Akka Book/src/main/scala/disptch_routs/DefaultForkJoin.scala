package disptch_routs
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import akka.routing.RoundRobinPool
object Despachador1{
  def main(args: Array[String]): Unit = {}
  val _system = ActorSystem.create("dispatching",ConfigFactory.load().getConfig("DispatcherExamples"))
  val actor = _system.actorOf(Props[MsgEchoActor].withDispatcher("default_thread_pool").withRouter(
            RoundRobinPool(5)))
  0 to 10 foreach {
    i => {actor ! i}     
  }
  _system.shutdown()
}