package disptch_routs
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import akka.routing.RoundRobinPool

object DefaultThreadPool{
  def main(args: Array[String]): Unit = {}
  val _system = ActorSystem.create("Dispatch_sys",ConfigFactory.load().getConfig("MyDispatcherExample"))
  val actor = _system.actorOf(Props[MsgEchoActor].withDispatcher("defaultDispatcher1").withRouter(RoundRobinPool(50)), "dsp")
  //val echoDispatch = _system.actorOf(Props[MsgEchoActor], "echoDispatch")
  0 to 10000 foreach {
    i => actor ! i
  }
  _system.shutdown()
}