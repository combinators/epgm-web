name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
libraryDependencies += "com.microsoft.azure" % "azure-documentdb" % "1.9.1"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.0"
libraryDependencies += filters



