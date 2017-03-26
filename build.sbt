name := """epgm-web"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala).enablePlugins(DockerPlugin)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "com.microsoft.azure" % "azure-documentdb" % "1.9.1"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.0"
libraryDependencies += filters

resolvers +=
  "Artifactory" at "http://localhost:8081/artifactory/epgm_artifactory/"


publishTo := Some("Artifactory Realm" at "http://localhost:8081/artifactory/epgm_artifactory")

credentials += Credentials("Artifactory Realm", "localhost", "admin", "Epgm@combinators")

libraryDependencies += "org.apache.derby" % "derby" % "10.4.1.3"
libraryDependencies += "com.spotify" % "docker-client" % "3.5.13"

dockerCommands := Seq()

import com.typesafe.sbt.packager.docker._

dockerCommands := Seq(
  Cmd("FROM", "ikaee/alpine-bash-java8"),
  Cmd("MAINTAINER", "ikaee"),
  Cmd("WORKDIR", "/opt/docker"),
  Cmd("ADD", "opt /opt"),
  ExecCmd("RUN", "chown", "-R", "daemon:daemon", "."),
  Cmd("USER", "daemon"),
  Cmd("ENV","APPLICATION_SECRET lnY7KObrO/P^T<@mTKt7olO@lxGi]yA[1=__?VDW;qY9WjebDM@YAQ9`dx9W4F2A"),
  ExecCmd("ENTRYPOINT", "bin/epgm-web"),
  ExecCmd("CMD", "")
)


