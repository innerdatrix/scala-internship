package ch12

/*
 * Los traits encapsulan variables y funciones, que pueden luego ser integradas en las clases.  
 * Una clase puede integrar dentro de si, cualquier numero de Traits que necesite.
 * :thin: “Not dense in arragment or distribution”
 * 2 formas de utilizar los traits: ampliando pequeñas interfaces o definiendo métodos apilables.
 * Todos los Traits extienden automáticamente de Any Ref.
 */
trait filosofia {
  def pensar
  {
    println("I consume memory, therefore I am!")
  }
}

//Traits can, for example, declare ﬁelds and maintain state. In fact, you can do 
//anything in a trait deﬁnition that you can do in a class deﬁnition, and the
//syntax looks exactly the same, with only two exceptions.

// 1 - First, a trait cannot have any “class” parameters
// 
// 2 - whereas in classes, super calls are statically bound, in traits, 
//     they are dynamically bound.
//
//the implementation to invoke will
//be determined anew each time the trait is mixed into a concrete class. This
//curious behavior of super is key to allowing traits to work as stackable mod-
//iﬁcations, which will be described in Section 12.5. The rules for resolving
//super calls will be given in Section 12.6.
