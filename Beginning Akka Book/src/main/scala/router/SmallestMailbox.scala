package router

import disptch_routs.MsgEchoActor

import akka.actor.actorRef2Scala
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.SmallestMailboxRouter

object SmallestMailbox{
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem.create("SmallestMailBoxRouterExample")
    val smallestMailBoxRouter = _system.actorOf(Props[MsgEchoActor].withRouter(SmallestMailboxRouter(5)), name = "mySmallestMailBoxRouterActor")
    1 to 10 foreach {
      i => smallestMailBoxRouter ! i
    }
    _system.shutdown()
  }
}