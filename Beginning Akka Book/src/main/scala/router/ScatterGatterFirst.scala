package router

import disptch_routs.RandomTimeActor

import scala.concurrent.Await
import scala.concurrent.duration._

import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.routing.ScatterGatherFirstCompletedRouter
import akka.util.Timeout

object ScatterGatterFirst {
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("SGFCRouterExample")
    val scatterGatherFirstCompletedRouter = _system.actorOf(Props[RandomTimeActor].withRouter(
      ScatterGatherFirstCompletedRouter(nrOfInstances = 5, within = 5 seconds)), name = "mySGFCRouterActor")

    implicit val timeout = Timeout(5 seconds)
    val futureResult = scatterGatherFirstCompletedRouter ? "message"
    val result = Await.result(futureResult, timeout.duration)
    System.out.println(result)

    _system.shutdown()
  }  
}