package futures

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FunFut{

  def main(args:Array[String]){
    
  val f1 = Future {"Hello" + "World!" }
  
  val liStr = "Hello World! Futures..."
  val validChars:List[Char] = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú', ' ')
    lazy val y:Char=0
    def cleanLine(line:String)={
      def check(x:Char) = if(validChars.contains(x)) x else y
      val lines = line.toLowerCase().map { x => check(x)}
      lines.foldLeft("")(_+_) 
    }
  println("#"+cleanLine(liStr)+"#")
    
  val f4 = f1 map { x => x.length }
    
  val f2 = Future.successful(3) 
  
  val f3 = f1 flatMap { x => 
    f2 map { y =>
      x.length * y
    }
  }
  
  val future1 = Future.successful(4)
  
  val future2 = future1.filter(_ % 2 == 0)  
  
  val failedFilter = future1.filter(_ % 2 == 1).recover {
    // When filter fails, it will have a java.util.NoSuchElementException
    case m: NoSuchElementException => 0
  }
    
  val lis = List(1,2)
  lazy val fact1 = Future {
    facto(lis.foldLeft(0)(_ + _))
  }
  
  lazy val lis2 = List(8,9,10,11,12)
  lazy val fact2 = Future {
    facto(lis2.foldLeft(0)(_ + _))
  }
 
  lazy val prodFuts = for {
   a <- fact1 
   b <- fact2
   //if c > 3 // Future.filter
  } yield b/a
  
  val fx = Future {List("Hello", "World!", "futures") }.map { x => x.map { y => facto(y.length) } }
  val fz = Future {"Hello"+"World!" }.map { x => facto(x.length) } 
  
  import scala.util.Random
  case class TrialFuture(id:String, time:Int){
    sleepp
    println(toString)
    //se evalua una vez; cuando se llama
    lazy val rand = Random.nextInt(time)
    def sleepp = Thread.sleep(rand); 
    override def toString = "["+id+", "+rand+"]"
  }
  val taim = 1250
  
  //si se usa lazy no se evalua (mientras no se llame)
  val acts = for {
   a <- Future {TrialFuture("a", taim)}
   b <- Future {TrialFuture("b", taim)} 
   c <- Future {TrialFuture("c", taim)} 
   d <- Future {TrialFuture("d", taim)}
   e <- Future {TrialFuture("e", taim)} 
  } yield List(a,b,c,d) 
  for (i <- 1 to 8){
     TrialFuture(" __________ X", taim)
  }
  //prodFuts.foreach { x => println(x) }
  fx.foreach { x => x.foreach { y => println(y) } }
  
  import scala.concurrent.duration.Duration
  val futures = (100 to 110) map {                                         // 
      i => Future {
         val s = i.toString                                               // 
         //print(s)
         s
      }
  }
  val f = Future.reduce(futures)((s1, s2) => s1 + s2)                  // 
  val ff = Await.result(f, Duration.Inf)   
  println(ff)
  }
  
  def facto(n:BigInt):BigInt = {if (n==1) 1 else n*facto(n-1)}
    
}