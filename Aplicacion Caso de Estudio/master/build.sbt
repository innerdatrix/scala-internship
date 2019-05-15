//
import NativePackagerHelper._
//
name := "master-node"
version := "1.0"
scalaVersion := "2.11.5"

mainClass in (Compile, run) := Some("Starter")
//
mainClass in (packageBin) := Some("Starter")
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