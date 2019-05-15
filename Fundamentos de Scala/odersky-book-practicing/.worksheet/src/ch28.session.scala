package ch28

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
  
  val ns = <span id="foo"><strong>Hello,</strong> World!</span>;System.out.println("""ns  : scala.xml.Elem = """ + $show(ns ));$skip(26); 
  
  println(ns.toString)}
}
/*

XML is a form of semi-structured data.
Semi-structured data is very helpful any time you need to serialize pro-
gram data for saving in a ﬁle or shipping across a network. Instead of con-
verting structured data all the way down to bytes, you convert it to and from
semi-structured data. You then use pre-existing library routines to convert
between semi-structured data and binary data, saving your time for more
important problems.

Scala lets you type in XML as a literal anywhere that an expression is valid.

• Class Node is the abstract superclass of all XML node classes.
• Class Text is a node holding just text. For example, the “stuff” part of
<a>stuff</a> is of class Text.
• Class NodeSeq holds a sequence of nodes. Many methods in the XML
library process NodeSeqs in places you might expect them to pro-
cess individual Nodes. You can still use such methods with individual
nodes, however, since Node extends from NodeSeq. This may sound
weird, but it works out well for XML. You can think of an individual
Node as a one-element NodeSeq.

	You can evaluate Scala code in the middle of an XML literal
	by using curly braces ({}) as an escape.
		
	A braces escape can include arbitrary Scala content, including further XML
literals. Thus, as the nesting level increases, your code can switch back and
forth between XML and ordinary Scala code.

If the code inside the curly braces evaluates to either an XML node or a se-
quence of XML nodes, those nodes are inserted directly as is.

scala> val yearMade = 1955
yearMade: Int = 1955

scala> <a> { if (yearMade < 2000) <old>{yearMade}</old>
else xml.NodeSeq.Empty } </a>

res2: scala.xml.Elem =
<a> <old>1955</old></a>

Extracting text. By calling the text method on any XML node you re-
trieve all of the text within that node, minus any element tags:
scala> <a> input ---&gt; output </a>.text
res9: String = input ---> output

Extracting sub-elements. If you want to ﬁnd a sub-element by tag name,
simply call \ with the name of the tag:

You can do a “deep search” and look through sub-sub-elements, etc., by
using \\ instead of the \ operator:

scala> <a><b><c>hello</c></b></a> \ "c"
res11: scala.xml.NodeSeq =

scala> <a><b><c>hello</c></b></a> \\ "c"
res12: scala.xml.NodeSeq = <c>hello</c>

Extracting attributes. You can extract tag attributes using the same \ and
\\ methods. Simply put an at sign (@) before the attribute name:

joe: scala.xml.Elem = <employee rank="code monkey" name="Joe" serial="123">
											</employee>

scala> joe \ "@name"
res15: scala.xml.NodeSeq = Joe
		
scala.xml.XML.save("therm1.xml", node)

scala> val loadnode = xml.XML.loadFile("therm1.xml")
		
*/
