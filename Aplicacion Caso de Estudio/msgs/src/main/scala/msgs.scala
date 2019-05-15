package msgs

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Map

sealed trait MapReduceMessage
case class WordCount(word:String, count:Integer) extends MapReduceMessage
case class Result() extends MapReduceMessage
case class MapData(val dataList: ArrayBuffer[WordCount]) extends MapReduceMessage
case class ReduceData(val reduceDataMap: Map[String, Int]) extends MapReduceMessage
