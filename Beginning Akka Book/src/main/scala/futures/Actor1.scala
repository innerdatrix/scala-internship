package futures

import akka.actor.{Actor, Props}
import akka.pattern.{ask, pipe}
import akka.util.Timeout
import akka.dispatch._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration.DurationInt

class Actor1 extends Actor{
  
  implicit val timeout = Timeout(5 seconds)
  val actor11 = context.actorOf(Props[Actor2], "actor11")
  
  def receive = {
    case num:BigInt => 
        val f: Future[BigInt] = (actor11 ask num).mapTo[BigInt]
        println(self+" returning...")
        (f) pipeTo sender 
    case _ => println(self+" :(")
  }
}
  
class Trial extends Actor{
   override def preStart{
      import scala.concurrent.duration.DurationInt
      import akka.util.Timeout
      implicit val timeout = Timeout(10 seconds)    
      val facts:List[BigInt] = List(2,10,20,30,50)
      import akka.routing.RoundRobinPool
      val mapActor = context.actorOf(Props[Actor1].withRouter(RoundRobinPool(facts.length)), name="factosss")  
      val x = facts.map { x => (mapActor ? x).mapTo[BigInt] }
      x.foreach { x => x.foreach { y => println("$$$$$ "+y) } }
      
      val t1 = context.actorOf(Props[Actor1], "t1")
      val t2 = context.actorOf(Props[Actor1], "t2")
      val t3 = context.actorOf(Props[Actor1], "t3")
     import futures.FunFut.facto
     println("------"+facto(120))
     val f3 = for {
                  a <- t1.ask(12:BigInt).mapTo[BigInt]
                  b <- t2.ask(5:BigInt).mapTo[BigInt]
                  c <- t3.ask(20:BigInt).mapTo[BigInt]
     } yield a+b+c
     //Thread.sleep(1000)
     println("------"+facto(25))
     println("------"+facto(100))
     f3.foreach { x => println(x) }
   }
   
   def receive = {
     case _ => println("WhatThe...")
   } 
}

object Trial{
  def main(args:Array[String]){
  import akka.actor.ActorSystem
  import akka.actor.Props
  
    val system = ActorSystem("askFutures")
    val trial = system.actorOf(Props[Trial], "starter")
    
  }
}