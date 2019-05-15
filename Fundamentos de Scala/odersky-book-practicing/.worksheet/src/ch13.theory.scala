package ch13

object theory {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet")}
}
/*
Usted puede colocar código en los paquetes nombrados en Scala de dos maneras.

En primer lugar, se puede colocar el contenido de todo un archivo en un paquete :.

La colocación de los contenidos de un archivo entero en un paquete:

package bobsrockets.navigation
class Navigator

La otra forma se puede colocar código en paquetes en Scala es más como C# espacios de
 trabajo (empaquetado).

package bobsrockets.navigation {
class Navigator
}

Cuando el código se divide en una jerarquía de paquetes, no sólo ayuda a la gente
navegar a través del código. También le dice al compilador que código en el mismo
paquete se relaciona de alguna manera con la otra.

package bobsrockets {
	package navigation {
		// In package bobsrockets.navigation
		class Navigator
		package tests {
			// In package bobsrockets.navigation.tests
			class NavigatorSuite
		}
	}
}

•	Una clase se puede acceder desde dentro de su propio paquete sin necesidad de un prefijo.
•	Un paquete en sí puede ser accedesado desde el paquete que lo contiene sin necesidad de
un prefijo.
•	Cuando se utiliza la sintaxis de llaves para paquetes, todos los nombres accesibles en
 ámbitos fuera del empacado también están disponibles en su interior.

package bobsrockets {
	package navigation {
		class Navigator {
			// No need to say bobsrockets.navigation.StarMap
			val map = new StarMap
		}
		class StarMap
	}
	class Ship {
		// No need to say bobsrockets.navigation.Navigator
		val nav = new navigation.Navigator
	}
	package fleets {
		class Fleet {
			// No need to say bobsrockets.Ship
			def addShip() { new Ship }
		}
	}
}

Si nos atenemos a un paquete por archivo, luego al igual que en Java los únicos nombres
 disponibles serán los que se definen en el paquete actual.

Puesto que ya no está encerrado en un empacado de bobrockets, los nombres de bobrockets
 no estan inmediatamente a su alcance.

Si los paquetes de anidación con llaves desplaza su código incómodamente a la derecha,
también se pueden utilizar múltiples cláusulas de paquetes sin llaves
(cláusulas encadenadas de paquetes).

package bobsrockets {
	class Ship
}
package bobsrockets.fleets {
	class Fleet {
		// Doesn’t compile! Ship is not in scope.
		def addShip() { new Ship }
	}
}

A veces, se termina codificando en un ámbito muy concurrido, donde los nombres de
paquetes se esconden entre sí.

¿Cómo hacer referencia a cada uno de Booster1, Booster2 y Booster3?

Scala ofrece un paquete llamado _root_ es decir fuera de cualquier paquete que un
 usuario puede escribir.

package launch {
	class Booster3
}

// In file bobsrockets.scala
package bobsrockets {
	package navigation {
		package launch {
			class Booster1
		}
		
		class MissionControl {
			val booster1 = new launch.Booster1
			val booster2 = new bobsrockets.launch.Booster2
			val booster3 = new _root_.launch.Booster3
		}
	}
	
	package launch {
		class Booster2
	}
}

Los paquetes y sus miembros pueden ser importados mediante cláusulas de importación.

Una cláusula de importación hace que los miembros de un paquete u objeto disponibles
 solo por sus nombres sin la necesidad de escribir prefijos antes del nombre del
 paquete u objeto.

// easy access to Fruit
import bobsdelights.Fruit

// easy access to all members of bobsdelights -ON-DEMAND-
import bobsdelights._

// easy access to all members of Fruits
import bobsdelights.Fruits._

package bobsdelights
	abstract class Fruit(
		val name: String,
		val color: String
	)
	
	object Fruits {
		object Apple extends Fruit("apple", "red")
		object Orange extends Fruit("orange", "orange")
		object Pear extends Fruit("pear", "yellowish")
		val menu = List(Apple, Orange, Pear)
	}

Las importaciones en Scala:
- Pueden aparecer en cualquier lugar, no sólo en el comienzo de una unidad de
 compilación.
- Puede referirse a objetos (singleton o regular), además de paquetes
- Le permite cambiar el nombre y ocultar algunos de los miembros a importar.


def showFruit(fruit: Fruit) {
	import fruit._
	println(name +"s are "+ color)
}

import java.util.regex
class AStarB {
	// Accesses java.util.regex.Pattern
	val pat = regex.Pattern.compile("a*b")
}

//This imports just members Apple and Orange from object Fruits.
import Fruits.{Apple, Orange}

//This imports the two members Apple and Orange from object Fruits.
//However, the Apple object is renamed to McIntosh.
import Fruits.{Apple => McIntosh, Orange}

//This imports all members from object Fruits but renames Apple to McIntosh.
import Fruits.{Apple => McIntosh, _}

//This imports all members of Fruits except Pear.
import Fruits.{Pear => _, _}

//Implicit imports: Scala adds some imports implicitly to every program.
import java.lang._ // everything in the java.lang package
import scala._ // everything in the scala package
import Predef._ // everything in the Predef object
// > scala import overshadows the java.lang


*/

/*

When working on a program, especially a large one, it is important to min-
imize coupling—the extent to which the various parts of the program rely
on the other parts.

Low coupling reduces the risk that a small, seemingly
innocuous change in one part of the program will have devastating conse-
quences in another part.

One way to minimize coupling is to write in a
modular style. You divide the program into a number of smaller modules,
each of which has an inside and an outside.

When working on the inside
of a module—its implementation—you need only coordinate with other pro-
grammers working on that very same module. Only when you must change
the outside of a module—its interface—is it necessary to coordinate with
developers working on other modules.

You can place code into named packages in Scala in two ways.
First, you can place the contents of an entire ﬁle into a package:

Placing the contents of an entire ﬁle into a package:
	package bobsrockets.navigation
	class Navigator

The other way you can place code into packages in Scala is more like
C# namespaces (packaging).
	package bobsrockets.navigation {
		class Navigator
	}

When code is divided into a package hierarchy, it doesn’t just help people
browse through the code. It also tells the compiler that code in the same
package is related in some way to each other.

package bobsrockets {
	package navigation {
		// In package bobsrockets.navigation
		class Navigator
		package tests {
			// In package bobsrockets.navigation.tests
			class NavigatorSuite
		}
	}
}

1. a class can be accessed from within its own package without needing a preﬁx.
2. a package itself can be accessed from its containing package without needing a preﬁx.
3. when using the curly-braces packaging syntax, all names accessi-
   ble in scopes outside the packaging are also available inside it.

package bobsrockets {
	package navigation {
		class Navigator {
			// No need to say bobsrockets.navigation.StarMap
			val map = new StarMap
		}
		class StarMap
		}
		class Ship {
			// No need to say bobsrockets.navigation.Navigator
			val nav = new navigation.Navigator
		}
		package fleets {
			class Fleet {
			// No need to say bobsrockets.Ship
			def addShip() { new Ship }
		  }
	  }
}

If you stick to one package per ﬁle, then—like in Java—the
	only names available will be the ones deﬁned in the current package.
Since it is no longer enclosed in a packaging for bobsrockets, names
	from bobsrockets are not immediately in scope.

If nesting packages with braces shifts your code uncom-
fortably to the right, you can also use multiple package clauses without the
braces (chained package clauses).

package bobsrockets {
	class Ship
}
package bobsrockets.fleets {
	class Fleet {
		// Doesn’t compile! Ship is not in scope.
		def addShip() { new Ship }
	}
}

Sometimes, you end up coding in a heavily crowded scope where package names are hiding each other.
 -  How would you reference each of Booster1, Booster2, and Booster3
Scala provides a package named _root_ that is outside any package a user can write.

package launch {
	class Booster3
}

// In file bobsrockets.scala
package bobsrockets {
	package navigation {
		package launch {
			class Booster1
		}
		
		class MissionControl {
			val booster1 = new launch.Booster1
			val booster2 = new bobsrockets.launch.Booster2
			val booster3 = new _root_.launch.Booster3
		}
	}
	
	package launch {
		class Booster2
	}
}


packages and their members can be imported using import clauses

An import clause makes members of a package or object available by
their names alone without needing to preﬁx them by the package or object
name.

// easy access to Fruit
import bobsdelights.Fruit

// easy access to all members of bobsdelights -ON-DEMAND-
import bobsdelights._

// easy access to all members of Fruits
import bobsdelights.Fruits._

package bobsdelights
	abstract class Fruit(
		val name: String,
		val color: String
	)
	
	object Fruits {
		object Apple extends Fruit("apple", "red")
		object Orange extends Fruit("orange", "orange")
		object Pear extends Fruit("pear", "yellowish")
		val menu = List(Apple, Orange, Pear)
	}

imports in Scala:
		- can appear anywhere, not just at the beginning of a compilation unit.
		- may refer to objects (singleton or regular) in addition to packages
		- let you rename and hide some of the imported members

def showFruit(fruit: Fruit) {
	import fruit._
	println(name +"s are "+ color)
}

import java.util.regex
class AStarB {
	// Accesses java.util.regex.Pattern
	val pat = regex.Pattern.compile("a*b")
}

//This imports just members Apple and Orange from object Fruits.
import Fruits.{Apple, Orange}

//This imports the two members Apple and Orange from object Fruits.
//However, the Apple object is renamed to McIntosh.
import Fruits.{Apple => McIntosh, Orange}

//This imports all members from object Fruits but renames Apple to McIntosh.
import Fruits.{Apple => McIntosh, _}

//This imports all members of Fruits except Pear.
import Fruits.{Pear => _, _}

//Implicit imports: Scala adds some imports implicitly to every program.
import java.lang._ // everything in the java.lang package
import scala._ // everything in the scala package
import Predef._ // everything in the Predef object
// > scala import overshadows the java.lang


Access modiﬁers

A private member is visible only inside the class or object that contains it.

In Scala, a protected member is only accessible from subclasses of the class
in which the member is deﬁned.

package p {
	class Super {
		protected def f() { println("f") }
	}
	class Sub extends Super {
		f()
	}
	class Other {
		(new Super).f() // error: f is not accessible
	}
}

Every member not labeled private or protected is public.
Such members can be accessed from anywhere.


Scope of protection

Access modiﬁers in Scala can be augmented with qualiﬁers.
A modiﬁer of the form private[X] or protected[X] means that access is private or
	protected “up to” X, where X designates some enclosing package, class or singleton object.


Scala also has an access modiﬁer that is even more restrictive than private.
A deﬁnition labeled private[this] is accessible only from within the same object that
contains the deﬁnition.
any access must not only be within class Navigator, but it must also be made from the
very same instance of Navigator.
 
 
package bobsrockets

package navigation {
		private[bobsrockets] class Navigator {
			protected[navigation] def useStarChart() {}
			class LegOfJourney {
				private[Navigator] val distance = 100
			}
			private[this] var speed = 200
	  }
}

package launch {
	import navigation._
	object Vehicle {
		private[launch] val guide = new Navigator
	}
}


Visibility and companion objects

A class shares all its access rights with its companion object and vice versa.

class Rocket {
	import Rocket.fuel
	private def canGoHomeAgain = fuel > 20
}
object Rocket {
	private def fuel = 10
	def chooseStrategy(rocket: Rocket) {
		if (rocket.canGoHomeAgain)
			goHome()
		else
			pickAStar()
	}
	def goHome() {}
	def pickAStar() {}
}


Package objects

Any kind of deﬁnition that you can put inside a class, you can also put at the
top level of a package.

To do so, put the deﬁnitions in a package object. Each package is allowed
to have one package object. Any deﬁnitions placed in a package object are
considered members of the package itself.

// In file bobsdelights/package.scala
package object bobsdelights {
	def showFruit(fruit: Fruit) {
	import fruit._
	println(name +"s are "+ color)
	}
}
// In file PrintMenu.scala
package printmenu
import bobsdelights.Fruits
import bobsdelights.showFruit
object PrintMenu {
	def main(args: Array[String]) {
		for (fruit <- Fruits.menu) {
			showFruit(fruit)
		}
	}
}

Package objects are compiled to class ﬁles named package.class that
are the located in the directory of the package that they augment.

So you would typically put the source ﬁle of the package object bobsdelights
of Listing 13.14 into a ﬁle named package.scala that resides in the bobsdelights directory.


Looking ahead:
hold package-wide type aliases (Chapter 20) and implicit conversions (Chapter 21).


*/
