name := "kafka-send-async-bug-fix"

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.3.0",
  "org.slf4j" % "slf4j-simple" % "1.7.25"
)

fork in run := true