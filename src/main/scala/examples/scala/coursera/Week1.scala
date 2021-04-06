package examples.scala.coursera

object Week1 extends App {
  def loop: Boolean = loop
  def x = loop //call-by-name
//  val y = loop //call-by-value

  def and(x: Boolean, y: Boolean) = {
    if(x == true) y else false
  }
  def or(x: Boolean, y: Boolean) = {
    if(x== true) true else y
  }

  def abs(x: Double) = if (x < 0) -x else x

//  println(sqrt(4))

  def sqrt(x: Double) = {

    def squrIter(guess: Double): Double =
      if (isGoodEnougth(guess)) guess
      else squrIter(improveGuess(guess))

    def isGoodEnougth(guess: Double) = {
      abs(guess * guess - x) / x < 0.001
    }

    def improveGuess(guess: Double) = {
      (guess + x / guess) / 2
    }
    squrIter(1)
  }

//   tail recursion is a compiler optimization which will
//     convert to a loop by which one stack frame is used


}
