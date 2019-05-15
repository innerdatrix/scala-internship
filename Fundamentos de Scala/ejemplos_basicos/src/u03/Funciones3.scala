package u03

/**
 * Este archivo está en formato UTF-8
 * Cálculo lambda (λ-calculus) de Alonso Church
 * 
 * Ejemplo:
 * λx.E, x = identificador y E = expresión
 * Si E = 3*x + 1
 * Entonces (λx.3*x+1)4 = 3*4+1 = 13
 * 
 * Ejemplo de λ a Scala:
 * λx.x+1
 * (x) => x+1
 * (x:Int) => x+1
 */

object Funciones3 extends App {
  //λx.x+1
  var incr = (x: Int) => x + x/10
  println(incr(incr(4)))
  
  //λxy.x*y
  var mul = (x: Int) => (y: Int ) => x * y //high-order function
  println(mul(3)(4))
  
  //λxy.x*x + y/x + 5
  var f1 = (x:Double) => (y:Int) => x*x + y/x + 5
  println(f1(4)(8))
}

// Haskell, Hutton - p. 34- 36
// using lambda expressions, which comprise a pattern for each of
//the arguments, a body that speciﬁes how the result can be calculated
//in terms of the arguments, but do not give a name for the function 
//itself. In other words, lambda expressions are nameless functions.
//
//, they can be used to formalise the meaning of curried function deﬁnitions
//
// are also useful when deﬁning functions that return functions as results
// by their very nature, rather than as a consequence of currying.
// 
// Finally, lambda expressions can be used to avoid having to name a function
//that is only referenced once. 