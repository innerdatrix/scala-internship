package map_reduce
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import msgs._
object Prueba{
  def main(args:Array[String]){
  val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    "do", "go", "if", "in", "is", "it", "of", "on", "the", "to")
  val words = "the past, the present and the future; walking across the space in time."
  
    //charsets: "utf-8", "iso-8859-1" (ANSI)
    val setChar = "iso-8859-1"
    def cleanLine(line:String):String={
       var cleanLine:String =""
       val validChars:List[Char] = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú', ' ')
       val linelist = line.toLowerCase().toList
       linelist.foreach { x => if(validChars.contains(x)) cleanLine += x  }
       cleanLine
    }
    def loadFile(){
      if(args.length > 0) {
        //var count = 0
        for(line <- Source.fromFile(args(0), setChar).getLines()){
          val clean = cleanLine(line)
          println(evaluateExpression(clean))     
          //count+=1
          //if(count==10)return
        }
      }
      else
        Console.err.println("No file name entered! ")  
    }
    loadFile()
    println(11)
  def evaluateExpression(line: String): MapData = MapData{
    line.split("""\s+""").foldLeft(ArrayBuffer.empty[WordCount]){
      (index, word) =>
      if(!STOP_WORDS_LIST.contains(word.toLowerCase))
        index += WordCount(word.toLowerCase, 1)
      else 
        index
    }
  }
  
  }
}

class Trial{
  override def toString = "trial: "+puntuation
  var puntuation:List[Int]= Nil
  for (n <- 122 to 97 by -1)
    puntuation = n :: puntuation
}