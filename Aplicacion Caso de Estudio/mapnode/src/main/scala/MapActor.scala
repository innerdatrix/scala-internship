
import scala.collection.mutable.ArrayBuffer
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorLogging
import akka.routing.FromConfig
import com.typesafe.config.ConfigFactory
import msgs.{MapData, WordCount}

class MapActor extends Actor with ActorLogging{
  override def preStart(){
	log.info("[Starting Remote MapNode...] > "+self.path)
  }
  
  val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    "do", "go", "if", "in", "is", "it", "of", "on", "the", "to")
  val defaultCount:Int=1
  def receive: Receive = {
    case message: String => sender ! evaluateExpression(message)
  }
  
  def evaluateExpression(line: String): MapData = MapData{
    line.split("""\s+""").foldLeft(ArrayBuffer.empty[WordCount]){
      (index, word) =>
      if(!STOP_WORDS_LIST.contains(word.toLowerCase)&&word.length()>=1)
          index += WordCount(word.toLowerCase, 1)
      else 
        index
    }
  }
  
  override def postStop(){
	log.info("[...ending Remote MapNode] > "+self.path)
  }
}

object MapActor{
  val _system = ActorSystem("RemoteMapNode", ConfigFactory.load())
  val map_actor = _system.actorOf(FromConfig.props(Props[MapActor]), name = "mapPool")
  def main(args: Array[String]) {
 
  }
}