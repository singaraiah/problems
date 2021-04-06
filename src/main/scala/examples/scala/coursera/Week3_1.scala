package examples.scala.coursera

import com.carrotsearch.hppc.IntSet

object Week3_1 {

}

abstract class InsSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

class Empty extends InsSet{
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = ???
}