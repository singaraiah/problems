package examples.spark

import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, column, desc, round, row_number, split}
import org.apache.spark.sql.types.{FloatType, IntegerType}

object TrySpark extends App {

  //  case class TestDS(bookID: String, title: String, authors: String, average_rating: String,
  //                    language_code: String, num_pages: Int, ratings_count: Int, text_reviews_count: Int)

  val spark = SparkSession
    .builder
    .master("local")
    .appName("Test")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val df = spark.read.format("csv").option("header", "true")
    .load("resources/books.csv")

  val modifiedDF = df.withColumn("average_rating", df.col("average_rating").cast(FloatType))
    .withColumn("num_pages", df.col("num_pages").cast(IntegerType))
    .withColumn("ratings_count", df.col("ratings_count").cast(IntegerType))
    .withColumn("text_reviews_count", df.col("text_reviews_count").cast(IntegerType))

//  getTopRatedBooks(modifiedDF).show()

  def getTopRatedBooks(df: sql.DataFrame) = {
    val win = Window.partitionBy("authors").orderBy(desc("average_rating"))
    df.withColumn("rating_order", row_number().over(win))
      .where(col("rating_order") === 1)
      .drop("rating_order")
  }

  val textData =
    """India is great
      |Sapient is hiring in India
      |Sapient is not hiring in Australia
      |dadlkas sd dsald sdad dasd asad sdad
      |""".stripMargin

  val rdd = spark.sparkContext.parallelize(Seq(textData)).flatMap(_.split("\n"))
  val maxVal = rdd.map(str => {
    (str, str.split(" ").contains("not") )
  })
    .foreach(x => println("new line " + x))

  rdd.filter(!_.split(" ").contains("not"))
//    .reduce((acc,x) => if(acc > x) acc else x)

//  println(maxVal)

}