
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits._

  def facto(n:Int):BigInt = {if (n==1) 1 else n*facto(n-1)}

  val lis = List(1,2,3,4,5,6)
  val fact1 = Future {
    lis.foldLeft(0)(_ + _) 
  }
  fact1 foreach println 
  
  