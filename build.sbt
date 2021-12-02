val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "adventofcode_2021",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
  )
