package examples.spark

import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, column, desc, round, row_number}
import org.apache.spark.sql.types.{FloatType, IntegerType}

object TrySpark extends App {

  case class TestDS(bookID: String, title: String, authors: String, average_rating: String,
                    language_code: String, num_pages: Int, ratings_count: Int, text_reviews_count: Int)

  val spark = SparkSession
    .builder
    .master("local")
    .appName("Test")
    .config("spark.testing.memory", "2147480000")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val df = spark.read.format("csv").option("header", "true")
    .load("C:\\IdeaProjects\\first\\src\\main\\resources\\books.csv")

  val modifiedDF = df.withColumn("average_rating", df.col("average_rating").cast(FloatType))
    .withColumn("num_pages", df.col("num_pages").cast(IntegerType))
    .withColumn("ratings_count", df.col("ratings_count").cast(IntegerType))
    .withColumn("text_reviews_count", df.col("text_reviews_count").cast(IntegerType))

  getTopRatedPageCount(modifiedDF).show()

  def getTopRatedPageCount(df: sql.DataFrame) = {
    val win = Window.partitionBy("authors").orderBy("average_rating")
    df.withColumn("rating_order", row_number().over(win))
      .where(col("rating_order") === 1)
  }

}