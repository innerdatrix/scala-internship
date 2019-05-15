package ch34

object conceptos {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

/*

Conceptually, the Scala library resembles the underlying Swing classes, but
hides much of their complexity.

 A MainFrame is like a normal Swing Frame except that closing it will also
 close the whole GUI application.

Frames have a number of attributes.
In Scala’s Swing API, such attributes are modeled as properties.
...that properties are encoded in Scala as pairs of getter and setter.

Getter / def title: String --- Setter / def title_ = (s: String)

The top frame is the root component of the Swing application. It is a
Container, which means that further components can be deﬁned in it. Ev-
ery Swing container has a contents property, which allows you to get and
set the components it contains. The getter contents of this property has type
Seq[Component], indicating that a component can in general have several
objects as its contents.

contents = new Button {

 A Panel is a container that displays all the components it con-
tains according to some ﬁxed layout rules. There are a number of different
possible layouts that are implemented by various subclasses of class Panel,
ranging from simple to quite intricate.

The contents property of the BoxPanel is an (initially empty) buffer, to
which the button and label elements are added with the += operator:
contents += button
contents += label


Handling events

A publisher publishes events. A subscriber subscribes with a publisher
to be notiﬁed of any published events. Publishers are also called
 “event sources,” and subscribers are also called “event listeners”.
 For instance a Button is an event source, which publishes an event,
 ButtonClicked, indicating that the button was clicked.
In Scala, subscribing to an event source source is done by the call
listenTo(source). There’s also a way to unsubscribe from an event source
using deafTo(source).

Being notiﬁed of events is only half the story; the other half is handling them.

 For instance, pressing a
button will create an event which is an instance of the following case class:
case class ButtonClicked(source: Button)

To have your component react to incoming events you need to add a
handler to a property called reactions. Here’s the code that does this:
var nClicks = 0
reactions += {
case ButtonClicked(b) =>
nClicks += 1
label.text = "Number of button clicks: "+ nClicks
}

The remaining lines add the code between braces as a handler to the reactions
property of the top frame. Handlers are functions deﬁned by pattern matching on event

The reactions property implements a collection, just like the contents
property does. Some components come with predeﬁned reactions.

If you install your own reactions by adding them with += to the reactions property,
the reactions you deﬁne will be considered in addition to the standard ones.

It’s also possible to remove handlers from the reaction property, using the -= operator.

import swing._
import event._

This is in fact equivalent to the imports used before:
import scala.swing._
import scala.swing.event._

The reason you can use the shorthand is that packages nest in Scala.

scala. <-- everything in that package imported automatically
scala.swing.event, is contained as subpackage event in package scala.swing.
 							you can refer to the event package with just event thereafter.

Note the form of the patterns, which include back ticks around the
element names: case EditDone(`celsius`)



*/