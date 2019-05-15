 package ch13

import bobsrockets.launch.Vehicle._
class Visacc {
   println(guide)
}

package bobsrockets
{
  
  package navigation {
      private[bobsrockets] class Navigatorr {
        protected[navigation] def useStarChart() {}
        class LegOfJourney {
          override def toString = " LegOfJourney " 
          private[Navigatorr] val distance = 100
          speed = speed + 100
        }
        private[this] var speed = 200
        def trial { speed = speed +10 ; println(speed)};
      }
      
      class Ejemplo 
      {
        val nav = new Navigatorr
        
      }
  }
  
  
  package launch {
    
    import navigation.Navigatorr    
    
    class Ejemplo02 extends Navigatorr
    {
        override def useStarChart() { println("Overrided! 2")}
    }
    
    object Vehicle                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  0000000000000000{
      private[ch13] val guide = new Navigatorr
      println(guide.toString())
    }
    
    class Movil
    {
      val veh = Vehicle
      println(veh.guide)
      veh.guide.trial
    }
  }
  
  
}