package map_reduce

import com.typesafe.config.ConfigFactory
import scala.io.Source
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Map
import scala.collection.mutable.HashMap
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import msgs.Result

object Starter{
  def main(args: Array[String]) {
    //charsets: "utf-8", "iso-8859-1" (ANSI)
    val setChar = "iso-8859-1"
    val filesize = Source.fromFile(args(0), setChar).size
    val linespro = Source.fromFile(args(0), setChar).getLines().length
    val wait = linespro
    val _system = ActorSystem("MapReduceApp", ConfigFactory.load())
    val n_routes = linespro/100
    val master = _system.actorOf(Props(new MasterActor(n_routes)), name = "master")
    val validChars:List[Char] = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú', ' ')

    val y:Char=0
    def cleanLine(line:String)={
      def check(x:Char) = if(validChars.contains(x)) x else y
      val lines = line.map { x => check(x).toString() }
      lines.foldLeft("")(_+_) 
    }
    var count = 0
    def loadFile()={
      if(args.length > 0) {
        for(line <- Source.fromFile(args(0), setChar).getLines()){
          val clean = cleanLine(line)
          master ! clean
          // Thread.sleep(5) - Local
          // Thread.sleep(8) - Remote
          count += 1
          Thread.sleep(7) 
        }
      }
      else
        Console.err.println("No file name entered! ")  
    }
    val startTime = System.nanoTime()
    loadFile()
    Thread.sleep(wait)  
    implicit val timeout = Timeout(wait seconds)
    val future = (master ? Result).mapTo[HashMap[String,Int]]
    val result = Await.result(future, timeout.duration)
    val finalTime:Double = (System.nanoTime() - startTime)/1000000000.0
    
    //result.foreach(f => println(f))
    println("Archivo: "+args(0))
    println("Tamaño de archivo (Bytes) : "+filesize)
    println("Lines processed: "+count)
    println("Map-Reduce time processing: "+finalTime+" seconds")
    println("Words processed: "+result.size)
    val start = System.nanoTime()
    val int_strin_list = result.toSeq.sortBy(_._2) 
    val finalt:Double = (System.nanoTime() - start)/1000000000.0
    int_strin_list.foreach(f => println(f))
    println("Time ordering final list: "+finalt+" seconds")
    
    _system.shutdown
  }
}