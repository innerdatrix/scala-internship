
name := "akka-remote-simple-scala"

version := "1.0"

scalaVersion := "2.11.5"

mainClass in (Compile, run) := Some("RemoteActor")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.3.9"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-remote" % "2.3.9"