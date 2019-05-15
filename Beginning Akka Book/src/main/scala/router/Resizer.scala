package router

import disptch_routs.MsgEchoActor

import akka.routing.DefaultResizer
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.RandomRouter

object Resizer {
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem.create("CustomRouteeRouterExample")

    val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)

    val randomRouter = _system.actorOf(Props[MsgEchoActor].withRouter(RandomRouter(resizer = Some(resizer))))
    1 to 10 foreach {
      i => randomRouter ! i
    }
    _system.shutdown()
  }
}