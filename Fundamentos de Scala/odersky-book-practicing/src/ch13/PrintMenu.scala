package ch13

// In file PrintMenu.scala
package printmenu

import ch13.showFruit
//import bobsdelights
object PrintMenu {
  def main() {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
