package examples.categories.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object prog {
  
  def main(args: Array[String]): Unit = {

    val sparkConfig = (new SparkConf())
      .set("spark.master", "local[*]")

    val spark = SparkSession
      .builder
      .config(sparkConfig)
      .getOrCreate()
//    val path  = "/Users/singaraiah.jakka/Desktop/test.csv"
    val path = "/Users/singaraiah.jakka/Projects/bit-bucket/transport-intelligence/geoimage-search/values.json"
    spark.read.format("csv").option("header", "true").load(path).createOrReplaceTempView("table")

    spark.read.format("json").load(path).createOrReplaceTempView("table")

    spark.sql("select * from table").show()

  }
}

class prog
