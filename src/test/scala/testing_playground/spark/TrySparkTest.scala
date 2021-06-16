package testing_playground.spark

import org.apache.spark.sql.SparkSession
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite
import examples.spark.TrySpark.getTopRatedBooks

class TrySparkTest extends AnyFunSuite with BeforeAndAfterEach {

  var spark : SparkSession = _

  override def beforeEach(): Unit = {
    spark = SparkSession.builder()
      .appName("unitTesting")
      .master("local[2]")
      .getOrCreate()
  }

  override def afterEach(): Unit = {
    spark.stop()
  }

  test("testing getTopRatedBooks function") {
    val sampleDF = spark.read.format("csv").option("header", "true")
      .load("resources/sample-books.csv")

    val outDF = spark.read.format("csv").option("header", "true")
      .load("resources/sample-books.csv")

    assert(getTopRatedBooks(sampleDF).schema.equals(outDF.schema) == true)

    assert {
      getTopRatedBooks(sampleDF)
        .orderBy("bookId").collect()
        .sameElements {
          outDF.orderBy("bookId").collect()
        } == true
    }

  }


}
