package examples.scala.coursera

import scala.annotation.tailrec

object Week2_5 extends App {
  val x = new Rational(16,24)

  println(new Rational(14,15))
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denom must be non zero")

  def this(x: Int) = this(x,1)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a%b)
  private val g = gcd(x, y)
  def numer = x/g
  def denom = y/g

  def add(that: Rational) =
    new Rational(numer*that.denom + denom*that.numer, denom*numer)

  def neg = new Rational(-numer, denom)

  override def toString = numer + " / " + denom
}
