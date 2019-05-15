package router

import disptch_routs.MsgEchoActor

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Address
import akka.routing.RandomRouter
//import akka.routing.RemoteRouterConfig
import akka.actor.Props

object Remote{
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem.create("RemoteRouteeRouterExample")

    val addr1 = Address("akka", "remotesys", "127.0.0.1", 2552)
    val addr2 = Address("akka", "remotesys", "127.0.0.1", 2552)

    val addresses = Seq(addr1, addr2)
/*
    val randomRouter = _system.actorOf(Props[MsgEchoActor].withRouter(RemoteRouterConfig(RandomRouter(5), addresses)))
    1 to 10 foreach {
      i => randomRouter ! i
    }
*/
    _system.shutdown()
  }
}