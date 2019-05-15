
// CUAL ES EL PAQUETE RAIZ DEL ELEMENTO A INSTANCIAR


//primer tipo de paquetes
package ch13
//primera o forma tradicional de empaquetado (de archivo)
import bobsrockets.fleets._

//ruta: ch13.Packs01
class Packs01 {
    override def toString = "Packs01 Here !"
    
    val fleet = new Fleet
    println(fleet)
}

// segundo tipo de empaquetado
package ch133{ }
//ruta: ch13.bobsrockets
package bobsrockets {
  
  //ruta: ch13.bobsrockets.navigation
  package navigation {
    
    //ruta: ch13.bobsrockets.navigation.Navigator
    class Navigator {
      override def toString = "Navigator Here !"
      
      // No need to say bobsrockets.navigation.StarMap   
      val map = new StarMap
      val ship01 = new Ship
    }
    
    //ruta: ch13.bobsrockets.navigation.StarMap
    class StarMap
    {
       override def toString = "StartMap Here !"
       
       val cero = Cero
       val paqs01 = new Packs01
       println(cero)

    }
  }
  
  //ruta: ch13.bobsrockets.Ship
  class Ship {
    override def toString = "Ship Here !"
    
    // No need to say bobsrockets.navigation.Navigator
    val nav = new navigation.Navigator
    val fleet = new Fleet
  }
  
  //ruta: ch13.bobsrockets.fleets
  package fleets {
    
    import navigation.{Navigator, StarMap}
    //ruta: ch13.bobsrockets.fleets.Fleet
    class Fleet {
       override def toString = "Fleets Here !"
       
      // No need to say bobsrockets.Ship
      def addShip() { new Ship }
      def navig() { new Navigator }
      def star() { new StarMap }
    }
  }
}