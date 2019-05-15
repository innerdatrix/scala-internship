
import scala.collection.immutable.Map
import scala.collection.mutable.HashMap
import akka.actor.Actor
import akka.actor.ActorLogging
import msgs.{ReduceData, Result}

class AggregateActor extends Actor with ActorLogging{
  override def preStart(){
	log.info("[Starting Aggregate Actor...] > "+self.path)
  }
  val finalReducedMap = new HashMap[String, Int]
  def receive: Receive = {
    case ReduceData(reduceDataMap) => aggregateInMemoryReduce(reduceDataMap)
    case Result =>
      sender ! finalReducedMap
  }

  def aggregateInMemoryReduce(reducedList: Map[String, Int]):Unit={
    for( (key, value) <- reducedList){
      if(finalReducedMap.contains(key))
        finalReducedMap(key) = (value + finalReducedMap.get(key).get)
      else
        finalReducedMap += (key -> value)
    }
  }
  
  override def postStop(){
	log.info("[...ending Aggregate Actor] > "+self.path)
  }
}