package examples.categories.strings

object NonRepeatingChar extends App {
  val str: String = "ABCDBAGHCDx"

  def nonRepeatingChar(str: String) = {
    val wordCounts = str.groupBy(x => x).mapValues(_.length).filter(_._2 == 1).toArray
    wordCounts
  }
//  println(nonRepeatingChar(str))
  nonRepeatingChar(str).foreach(println)
//  println(str.groupBy(x => x))
}
