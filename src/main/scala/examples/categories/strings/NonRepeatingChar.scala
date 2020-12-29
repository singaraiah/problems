package examples.categories.strings

object NonRepeatingChar extends App {
  def nonRepeatingChar(str: String) = {
    //    val str: String = "ABCDBAGHCD"
    val wordCounts = str.groupBy(x => x).mapValues(_.length).filter(_._2 == 1).toArray
    wordCounts(0)._1
  }
  println(nonRepeatingChar("ABCDBAGHCD"))
}
