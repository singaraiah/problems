name := "Problems"

version := "0.1"

//scalaVersion := "2.11.8"

scalaVersion := "2.12.8"

libraryDependencies ++=
  Seq("org.apache.spark" %% "spark-core" % "2.4.2",
    "org.apache.spark" %% "spark-sql" % "2.4.2",
    "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
    "org.yaml" % "snakeyaml" % "1.25",
    "org.elasticsearch" % "elasticsearch-hadoop" % "6.4.2"
  )