package examples.categories.strings

import scala.collection.mutable

object Permutations extends App {

  def swap(str: mutable.ListBuffer[Char], i: Int, j: Int) = {
    val resStr = str
    val tempChar = str(i)
    resStr(i) = str(j)
    resStr(j) = tempChar
    resStr
  }

  def permutations(str: mutable.ListBuffer[Char], i: Int): Unit = {
    var tmp = str
    if (i == str.length) {
      println(str)
    } else {
      for (x <- i to str.length - 1) {
        tmp = swap(str, i, x)
        permutations(tmp, i + 1)
        println(x,i)
//        tmp = swap(tmp, i, x)
//        println(s"tmp after 2nd swap $tmp")
        
      }
    }
  }

  permutations("abc".to[mutable.ListBuffer], 0)


}
