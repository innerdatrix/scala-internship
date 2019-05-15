package new_rout
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.routing.RoundRobinGroup
import akka.routing.FromConfig
import akka.actor.Actor
import disptch_routs.MsgEchoActor
import disptch_routs.RandomTimeActor
object MyRoundRobinGroupApp{
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("RoundRobinGroupEx")
    //aplication.conf
    val robinGroup: ActorRef = _system.actorOf(FromConfig.props(), "robinGroup")
    //programatically
    val echo1=_system.actorOf(Props[MsgEchoActor], name = "echo01")
    val echo2=_system.actorOf(Props[MsgEchoActor], name = "echo02")
    val paths = List("/user/echo01", "/user/echo02")
    val myRoundRobinGroup: ActorRef = _system.actorOf(RoundRobinGroup(paths).props(), "myRoundRobinGroup")
    val sender = _system.actorOf(Props[Sender], name="sender")
    Thread.sleep(1000)
    _system.shutdown()
  }
}
class Sender extends Actor{
  override def preStart(){
    val router = context.actorSelection("/user/myRoundRobinGroup")
    val router2 = context.actorSelection("/user/robinGroup")
    1 to 8 foreach {
      i => {router ! i;router2 ! i}
    }
  }
  def receive:Receive={
    case message => println("Got it: "+message)
  }
}
