organization := "de.sgeorgi"

name := "count-stash"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" 	%% "akka-actor" % "2.3.5",
  "com.typesafe.akka" 	%% "akka-testkit" % "2.3.5" % "test",
  "org.scalatest" 	% "scalatest_2.11" % "2.2.1" % "test",
  "org.reactivemongo" 	%% "reactivemongo" % "0.10.5.akka23-SNAPSHOT"
)

Revolver.settings: Seq[sbt.Def.Setting[_]]
