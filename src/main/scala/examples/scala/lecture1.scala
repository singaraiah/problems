package examples.scala

import scala.math.abs

object lecture1 {
  def main(args: Array[String]): Unit = {

    println("lecture link is ----> https://www.coursera.org/learn/progfun1/lecture/FQDE1/lecture-1-5-example-square-roots-with-newtons-method")

    val coinsMultipliers = List[Int](3)
    println(balanceParenthesis("()(())".toList))

  }

  def balanceParenthesis(chars: List[Char]): Boolean = {

    def balanceIter(subChars: List[Char], parenthesisBal: Int): Boolean = {
      if (subChars.isEmpty) if (parenthesisBal == 0) true else false
      else {
        if (subChars.head == '(' && parenthesisBal >= 0) balanceIter(subChars.tail, parenthesisBal + 1)
        else if (subChars.head == '(' && parenthesisBal < 0) false
        else if (subChars.head == ')') balanceIter(subChars.tail, parenthesisBal - 1)
        else balanceIter(subChars.tail, parenthesisBal)
      }
    }

    balanceIter(chars, 0)
  }


  def countChange(money: Int, coins: List[Int]) = {

    def countChangeIter(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money < 0 || coins.isEmpty)
        0
      else
        countChangeIter((money - coins.head), coins) + countChangeIter(money, coins.tail)
    }

    countChangeIter(money, coins)
  }

  //   column and rows starts with  0
  //         c0  c1  c2  c3  c4  c5
  //  r-0 -- 1
  //  r-1 -- 1   1
  //  r-2 -- 1   2   1
  //  r-3 -- 1   3   3   1
  //  r-4 -- 1   4   6   4   1
  //  r-5 -- 1   5   10  10  5   1
  //
  def pascal(r: Int, c: Int): Int = {
    if (c == 0 && c <= r) 1
    else if (c > r) 0
    else pascal(r - 1, c - 1) + pascal(r - 1, c)
  }


  def sqrt(x: Double) = {

    def isGoodEnough(guess: Double) = {
      abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double) = {
      (guess + x / guess) / 2
    }

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))
    }

    sqrtIter(1)
  }

}
