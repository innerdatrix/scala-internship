package router
import scala.actors.threadpool.TimeUnit;
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.RoundRobinRouter
import disptch_routs.MsgEchoActor

object RoundRobin{
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("RoundRobinRouterExample")
    val roundRobinRouter = _system.actorOf(Props[MsgEchoActor].withRouter(RoundRobinRouter(5)), name = "myRoundRobinRouterActor")
    1 to 10 foreach {
      i =>
        roundRobinRouter ! i
        if (i == 5) {
          TimeUnit.MILLISECONDS.sleep(100);
          System.out.println("\n");
        }
    }
    _system.shutdown()
  }
}