//
import NativePackagerHelper._
//
name := "map-node"
version := "1.0"
scalaVersion := "2.11.5"

mainClass in (Compile, run) := Some("MapActor")
//
mainClass in (packageBin) := Some("MapActor")
//
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.9"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.9"
//
libraryDependencies += "com.typesafe.akka" %% "akka-kernel" % "2.3.9"
enablePlugins(JavaServerAppPackaging)
mappings in Universal ++= {
directory("scripts") ++   
contentOf("src/main/resources").toMap.mapValues("config/" + _) 
}
scriptClasspath := Seq("../config/") ++ scriptClasspath.value
//