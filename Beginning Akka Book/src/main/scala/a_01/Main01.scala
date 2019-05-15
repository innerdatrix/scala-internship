package a_01
object Main01 {
  def main(args: Array[String]): Unit = {
    akka.Main.main(Array(classOf[HelloWorld].getName))
  }
}