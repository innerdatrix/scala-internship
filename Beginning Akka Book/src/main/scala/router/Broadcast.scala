package router

import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.BroadcastRouter

import disptch_routs.MsgEchoActor

object Broadcast{

  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("BroadcastRouterExample")
    val broadcastRouter = _system.actorOf(Props[MsgEchoActor].withRouter(BroadcastRouter(5)), name = "myBroadcastRouterActor")
    1 to 1 foreach {
      i => broadcastRouter ! i
    }
    _system.shutdown()
  }

}