package examples.categories.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.elasticsearch.spark._

object prog {
  
  def main(args: Array[String]): Unit = {

    val sparkConfig = (new SparkConf())
      .set("spark.master", "local[*]")
      .set("es.nodes", "localhost")
      .set("es.net.ssl", "true")
      .set("es.port", "9200")
//      .set("es.nodes.discovery", "true")

    val spark = SparkSession
      .builder
      .config(sparkConfig)
      .getOrCreate()
//    val path  = "/Users/singaraiah.jakka/Desktop/test.csv"
//    val path = "/Users/singaraiah.jakka/Projects/bit-bucket/transport-intelligence/geoimage-search/values.json"
//    spark.read.format("csv").option("header", "true").load(path).createOrReplaceTempView("table")
//
//    spark.read.format("json").load(path).createOrReplaceTempView("table")
//
//    spark.sql("select * from table").show()


    val esRdd = spark.sparkContext.esRDD("z_17_tile_baseindex_2_4")
    esRdd.take(10)
  }
}

class prog
