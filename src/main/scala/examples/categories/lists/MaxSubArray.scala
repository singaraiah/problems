package examples.categories.lists

import scala.collection.mutable

object MaxSubArray extends App {

  val list = List(-2, 1, -3, 4, -1, 2, 1, -5, 4)
  val resList = mutable.ListBuffer[Int]()

  def maxSubArray(list: List[Int]) = {
    resList += list(0)
    for( i <- 1 to list.length-1) {
      val ele = if (resList(i-1)+list(i) > list(i)) resList(i-1)+list(i) else list(i)
      resList += ele
    }
  }

  maxSubArray(list)

  println(resList)
}
