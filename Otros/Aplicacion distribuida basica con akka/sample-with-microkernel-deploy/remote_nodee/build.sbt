	
	import NativePackagerHelper._
     
    name := "remote_nodee"
     
    version := "1.0"
    
    scalaVersion := "2.11.5"
     
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
    
	mainClass in (Compile, run) := Some("_01.RemoteApp")
	mainClass in (packageBin) := Some("_01.RemoteApp")
	
	libraryDependencies ++= Seq( 
	  "com.typesafe.akka" %% "akka-actor" % "2.3.9", 
	  "com.typesafe.akka" %% "akka-kernel" % "2.3.9",
	  "com.typesafe.akka" %% "akka-remote" % "2.3.9"	  
	)
	//libraryDependencies += "com.typesafe" % "config" % "1.2.1" 	

	enablePlugins(JavaServerAppPackaging)
	
	mappings in Universal ++= {
	// optional example illustrating how to copy additional directory
       directory("scripts") ++
    // copy configuration files to config directory
       contentOf("src/main/resources").toMap.mapValues("config/" + _) 
    }
	// add 'config' directory first in the classpath of the start script,
	// an alternative is to set the config file locations via CLI parameters
	// when starting the application
	scriptClasspath := Seq("../config/") ++ scriptClasspath.value