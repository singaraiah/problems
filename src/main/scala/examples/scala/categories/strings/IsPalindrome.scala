package examples.scala.categories.strings

object IsPalindrome extends App {
  def problem1V2(str: String) = {
//    val str = "aabbccdde"
    val abc = str.groupBy(x => x).mapValues(_.length).filter(_._2 % 2 == 1)
    if(str.length % 2 == 1 && abc.size == 1) true else false
  }

  println(problem1V2("aabbccdde"))
}
