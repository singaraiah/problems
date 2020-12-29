package examples.categories.strings

object MinCharPalindrome extends App {
  // Minimum Characters required to make a String Palindromic

  solve("abcd")

  def checkPalindrom(str: String): Boolean = {
    val len = str.length
    if (len > 1 && str(0) == str(len - 1))
      checkPalindrom(str.splitAt(1)._2.splitAt(len - 2)._1)
    else if (len == 1 || str.isEmpty) true
    else false
  }

  def findAllSubStrings(str: String) = {
    for (i <- 0 to str.length - 1) {
      for (j <- i + 1 to str.length) {
        println(str.slice(i, j))
        println(checkPalindrom(str.slice(i, j)))
      }
    }
  }

  def solve(str: String)  = {
    var right = 0
    for(i <- 1 to str.length) yield {
      println(str.splitAt(i)._1)
      if(checkPalindrom(str.splitAt(i)._1)) right = i
    }
    println(str.length-right)
  }

}
