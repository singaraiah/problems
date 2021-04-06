package examples.scala.categories.strings

import scala.collection.mutable

object Permutations extends App {

  def swap(str: mutable.ListBuffer[Char], i: Int, j: Int) = {
    val resStr = str
    val tempChar = str(i)
    resStr(i) = str(j)
    resStr(j) = tempChar
    resStr
  }

  def permutations(str: mutable.ListBuffer[Char], left: Int): Unit = {

    if( left == str.length - 1) {
      println(str)
    } else {
      for(right <- left to str.length - 1) {
        swap(str, left, right)
        permutations(str, left + 1)
        swap(str, left, right)
      }
    }
  }

  permutations("abcd".to[mutable.ListBuffer], 0)


}
