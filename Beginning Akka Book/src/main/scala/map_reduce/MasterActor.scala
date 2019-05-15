package map_reduce

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.RoundRobinPool
import msgs._

class MasterActor(val routes:Int) extends Actor {
  
  //val mapActor = context.actorOf(Props[MapActor].withRouter(RoundRobinPool(routes)), name="map")
  val remoteMap = context.actorSelection("akka.tcp://RemoteMapNode@127.0.0.1:2222/user/mapPool")
  //val reduceActor = context.actorOf(Props[ReduceActor].withRouter(RoundRobinPool(routes)), name="reduce")
  val remoteReduce = context.actorSelection("akka.tcp://RemoteReduceNode@127.0.0.1:3333/user/reducePool")
  val aggregateActor = context.actorOf(Props[AggregateActor], name="aggregate")
  //val remoteAgregate = context.actorSelection("akka.tcp://RemoteAgregateNode@127.0.0.1:4444/user/agregateActor")
  
  def receive: Receive = {
    case line: String => remoteMap ! line
    case mapData:MapData => remoteReduce ! mapData
    case reduceData: ReduceData => aggregateActor ! reduceData
    case Result => aggregateActor forward Result
  }
}