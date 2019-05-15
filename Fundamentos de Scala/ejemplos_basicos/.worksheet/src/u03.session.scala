package u03

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet")}
}

/*

=>  significa una asociacion directa del lado izquierdo hacia el lado derecho

*/

/*

Odersky Glosary

free variable:
A free variable of an expression is a variable that’s used inside
the expression but not deﬁned inside the expression. For instance, in
the function literal expression (x: Int) => (x, y), both variables x
and y are used, but only y is a free variable, because it is not deﬁned
inside the expression.

function literal:
A function with no name in Scala source code, speciﬁed
with function literal syntax. For example, (x: Int, y: Int) => x + y.

bound variable:
A bound variable of an expression is a variable that’s both
used and deﬁned inside the expression. For instance, in the function
literal expression (x: Int) => (x, y), both variables x and y are used,
but only x is bound, because it is deﬁned in the expression as an Int
and the sole argument to the function described by the expression.

Odersky p.195-197

closure:
A function object that captures free variables, and is said to be
“closed” over the variables visible at the time it is created.

scala> var more = 1
more: Int = 1
scala> val addMore = (x: Int) => x + more
addMore: (Int) => Int = <function1>
scala> addMore(10)
res17: Int = 11

The function value (the object) that’s created at runtime from this function
literal is called a closure. The name arises from the act of “closing” the func-
tion literal by “capturing” the bindings of its free variables. A function literal
with no free variables, such as (x: Int) => x + 1, is called a closed term,
where a term is a bit of source code. Thus a function value created at run-
time from this function literal is not a closure in the strictest sense, because
(x: Int) => x + 1 is already closed as written. But any function literal with
free variables, such as (x: Int) => x + more, is an open term. Therefore,
any function value created at runtime from (x: Int) => x + more will by
deﬁnition require that a binding for its free variable, more, be captured. The
resulting function value, which will contain a reference to the captured more
variable, is called a closure, therefore, because the function value is the end
product of the act of closing the open term, (x: Int) => x + more.

currying:
A way to write functions with multiple parameter lists. For in-
stance def f(x: Int)(y: Int) is a curried function with two param-
eter lists. A curried function is applied by passing several arguments
lists, as in: f(3)(4). However, it is also possible to write a partial
application of a curried function, such as f(3).

*/

/* p.309
	case classes and pattern matching, twin constructs
that support you when writing regular, non-encapsulated data structures.
These two constructs are particularly helpful for tree-like recursive data.
If you have programmed in a functional language before, then you will
probably recognize pattern matching. Case classes will be new to you,
though. Case classes are Scala’s way to allow pattern matching on objects
without requiring a large amount of boilerplate. In the common case, all you
need to do is add a single case keyword to each class that you want to be
pattern matchable.

p.310

 Classes with such a modiﬁer are called case
classes. Using the modiﬁer makes the Scala compiler add some syntactic
conveniences to your class.

First, it adds a factory method with the name of the class.
This means you can write say, Var("x") to construct a Var object instead
 of the slightly longer new Var("x")
scala> val op = BinOp("+", Number(1), v)
op: BinOp = BinOp(+,Number(1.0),Var(x))

The second syntactic convenience is that all arguments in the parameter list
of a case class implicitly get a val preﬁx, so they are maintained as ﬁelds:

scala> v.name
res0: String = x
scala> op.left
res1: Expr = Number(1.0)

p.311

Third, the compiler adds “natural” implementations of methods toString,
hashCode, and equals to your class. They will print, hash, and compare a
whole tree consisting of the class and (recursively) all its arguments.

Finally, the compiler adds a copy method to your class for making modiﬁed
copies

p. 312

The right-hand side of simplifyTop consists of a match expression.
match corresponds to switch in Java, but it’s written after the selector ex-
pression. I.e., it’s:
selector match { alternatives }
instead of:
switch (selector) { alternatives }

A pattern match includes a sequence of alternatives, each starting with the
keyword case. Each alternative includes a pattern and one or more expres-
sions, which will be evaluated if the pattern matches. An arrow symbol =>
separates the pattern from the expressions.
A match expression is evaluated by trying each of the patterns in the
order they are written. The ﬁrst pattern that matches is selected, and the part
following the arrow is selected and executed.

p.282
In Scala, packages and their members can be imported using import clauses.
Imported items can then be accessed by a simple name like File, as opposed
to requiring a qualiﬁed name like java.io.File.

p.213
A curried function is applied to multiple argument lists, instead of just
one.

p.214
scala> def plainOldSum(x: Int, y: Int) = x + y
plainOldSum: (x: Int,y: Int)Int
scala> plainOldSum(1, 2)
res4: Int = 3

By Contrast

scala> def curriedSum(x: Int)(y: Int) = x + y
curriedSum: (x: Int)(y: Int)Int
scala> curriedSum(1)(2)
res5: Int = 3

What’s happening here is that when you invoke curriedSum, you actu-
ally get two traditional function invocations back to back. The ﬁrst function
invocation takes a single Int parameter named x, and returns a function
value for the second function. This second function takes the Int parameter
y. Here’s a function named first that does in spirit what the ﬁrst traditional
function invocation of curriedSum would do:

scala> def first(x: Int) = (y: Int) => x + y
first: (x: Int)(Int) => Int

Applying 1 to the ﬁrst function—in other words, invoking the ﬁrst function
and passing in 1—yields the second function:

scala> val second = first(1)
second: (Int) => Int = <function1>

Applying 2 to the second function yields the result:

scala> second(2)
res6: Int = 3

p.215

 Nevertheless, there is a way to get an actual reference to curriedSum’s
 “second” function. You can use the placeholder notation to use curriedSum
 in a partially applied function expression, like this:

scala> val onePlus = curriedSum(1)_
onePlus: (Int) => Int = <function1>

The underscore in curriedSum(1)_ is a placeholder for the second parame-
ter list.

The result is a reference to a function that, when invoked, adds one
to its sole Int argument and returns the result:

scala> onePlus(2)
res7: Int = 3


p.156

You can create an implicit conversion that automatically converts integers
to rational numbers when needed. Try adding this line in the interpreter:
scala> implicit def intToRational(x: Int) = new Rational(x)
This deﬁnes a conversion method from Int to Rational. The implicit
modiﬁer in front of the method tells the compiler to apply it automatically in
a number of situations.
Note that for an implicit conversion to work, it needs to be in scope.

*/
