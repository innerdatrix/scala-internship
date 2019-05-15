package ch28

import scala.xml._

object Misc {
  //We must define abstract class instance members
  val therm = new CCTherm {
    val description = "hot dog #5"
    val yearMade = 1952
    val dateObtained = "March 14, 2006"
    val bookPrice = 2199
    val purchasePrice = 500
    val condition = 9
  }
  val node = therm.toXML
  
  def genenXML(){
    //println("node [" + CCTherm.catalog + "]")
    scala.xml.XML.save("D:/w7/data/residencia/functional/scala/code/ment/odersky/src/ch28/therm1.xml", CCTherm.catalog)
  }  
  
  def xml_search(catalog : Node)
  {
	  catalog match {
	  case <catalog>{therms @ _*}</catalog> => {
      	  for (therm @ <cctherm>{_*}</cctherm> <- therms)
            if(therm.toString().contains('#'))
      		  println("> "+
      				  (therm \ "description").text)
          }      
    case _ => println("> It's ssomething else.")
    }
  }  
  
  def main(args: Array[String])
  {
    println("Starting XML processing...")
    
    //genenXML()
    println(" - xml generated - ")
    
    val get_xml_file : Node = XML.load("D:/w7/data/residencia/functional/scala/code/ment/odersky/src/ch28/therm1.xml")
    
    println("Searching...")
    xml_search(get_xml_file)
    xml_search(node)
    
    println("...processing has finished")
  }
}
