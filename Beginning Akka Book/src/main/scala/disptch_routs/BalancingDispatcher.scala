package disptch_routs

import akka.actor.ActorRef
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import akka.routing.BalancingPool

object BalancingDispatcher{
  def main(args: Array[String]): Unit = {}
  val _system = ActorSystem.create("balancing-dispatcher",ConfigFactory.load().getConfig("MyDispatcherExample"))

  val actor = _system.actorOf(Props[MsgEchoActor].withDispatcher("balancingDispatcher").withRouter(
            BalancingPool(5)))

  0 to 25 foreach {
    i => actor ! i
  }
  _system.shutdown()
}