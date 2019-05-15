package new_rout
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.RoundRobinPool
import disptch_routs.MsgEchoActor
import akka.routing.FromConfig
object RoundRobinPoolObj{
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("RoundRobinRouterExample")
    //programatically
    val routr = _system.actorOf(RoundRobinPool(5).props(Props[MsgEchoActor]), "myRoutr")
    //application.conf
    val routr2 = _system.actorOf(FromConfig.props(Props[MsgEchoActor]), "robinPool")
    1 to 8 foreach {
      i => {routr ! i;routr2 ! i}
    }
    _system.shutdown()
  }
}