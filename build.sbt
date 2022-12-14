name := "Problems"

version := "0.1"

//scalaVersion := "2.11.8"

scalaVersion := "2.12.8"

val sparkVersion = "2.4.7"

libraryDependencies ++=
  Seq("org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-streaming" % sparkVersion,
    "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
    "org.yaml" % "snakeyaml" % "1.25",
    "org.elasticsearch" % "elasticsearch-hadoop" % "6.4.2",
    "org.scalatest" %% "scalatest" % "3.2.5" % "test",
    "org.scalatestplus" %% "mockito-3-4" % "3.2.5.0" % "test"
  )