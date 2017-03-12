name := """epgm-web"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "com.microsoft.azure" % "azure-documentdb" % "1.9.1"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.0"
libraryDependencies += "net.debasishg" %% "redisclient" % "3.3"
libraryDependencies += "redis.clients" % "jedis" % "2.9.0"
libraryDependencies += filters

resolvers +=
  "Artifactory" at "http://localhost:8081/artifactory/epgm_artifactory/"

publishTo := Some("Artifactory Realm" at "http://localhost:8081/artifactory/epgm_artifactory")

credentials += Credentials("Artifactory Realm", "localhost", "admin", "Epgm@combinators")

libraryDependencies += "org.apache.derby" % "derby" % "10.4.1.3"



