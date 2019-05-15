
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorLogging
import akka.routing.FromConfig
import com.typesafe.config.ConfigFactory
import scala.collection.immutable.Map
import msgs.{MapData, WordCount, ReduceData}

class ReduceActor extends Actor with ActorLogging{
  override def preStart(){
	log.info("[Starting Remote ReduceNode...] > "+self.path)
  }
  
  def receive: Receive = {
    case MapData(dataList) =>
      sender ! reduce(dataList)
  }

  def reduce(words: IndexedSeq[WordCount]): ReduceData = ReduceData{
    words.foldLeft(Map.empty[String, Int]) { (index, words) => 
      if(index contains words.word)
        index + (words.word -> (index.get(words.word).get+1))
      else 
        index + (words.word -> 1)
    }
  }
    
  override def postStop(){
	log.info("[...ending Remote MapNode] > "+self.path)
  }
}

object ReduceActor{
  val _system = ActorSystem("RemoteReduceNode", ConfigFactory.load())
  val map_actor = _system.actorOf(FromConfig.props(Props[ReduceActor]), name = "reducePool")
  def main(args: Array[String]) {

  }
}