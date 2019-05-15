package ch13


class Boosters {
    override def toString = "Boosters !"
    
    class BoosterChild01
    {
      override def toString = "Small Child01 :) "
      def repeat = Boosters.greet+" :) "
    }
    
    val myChild = new BoosterChild01
}

object Boosters
{
     def greet = "We are Boosters"
}

import bobsrockets.navigation.{MissionControl => MC}

object BoostersStand
{
    def main(args :Array[String])
    {
        val booster01 = new Boosters
        println(booster01)
        println(booster01.myChild)
        println(Boosters.greet)
        println(booster01.myChild.repeat)
        
        //
        val bts = new MC
        println(bts.booster3)
        println(bts.booster2)
        println(bts.booster1)
        println(bts)
    }
}

package launch {
  class Booster3
  {
    override def toString = "Booster3"
  }
}

// In file bobsrockets.scala
package bobsrockets {
  package navigation {
    package launch {
      class Booster1
      {
        override def toString = "Booster1"
      }
    }
    
    class MissionControl {
      override def toString = Boosters.greet+" too"
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      val booster3 = new _root_.ch13.launch.Booster3
    }
  }
  
  package launch {
    class Booster2
    {
      override def toString = "Booster2"
    }
  }
}
